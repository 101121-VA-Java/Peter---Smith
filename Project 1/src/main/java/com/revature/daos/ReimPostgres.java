package com.revature.daos;

import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.ErsReimbursement;
import com.revature.models.ErsStatus;
import com.revature.models.ErsType;
import com.revature.models.ErsUsers;
import com.revature.util.ConnectionUtil;

public class ReimPostgres implements ReimDao{
	private static Logger log = LogManager.getRootLogger();
	
	@Override
	public List<ErsReimbursement> getPending() {
		String sql = "select * from ers_reimb join ers_status on ers_reimb.b_status_id = ers_status.s_id where ers_status.s_status = 'Pending';";                
		List<ErsReimbursement> reimbs = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			Statement ps = connect.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				int id1 = rs.getInt("b_id");
				Double amount = rs.getDouble("b_amount");
				Timestamp submitted = rs.getTimestamp("b_submitted");
				Timestamp resolved = rs.getTimestamp("b_resolved");
				String description = rs.getString("b_description");
				Blob receipt = rs.getBlob("b_receipt");
				int userId = rs.getInt("b_author_id");
				
				ErsReimbursement emp = new ErsReimbursement(id1, amount, submitted, resolved, description, receipt, new ErsUsers(userId,null, null, null, null, null, null), 
						null, null, null);    
				reimbs.add(emp);
				}
		
		} catch (SQLException |IOException e) {
			log.error("Error while trying to get item.");
			e.printStackTrace();
		} 
	return reimbs;
	}

	@Override
	public ErsReimbursement getById(int id) {
		String sql = "select * from ers_reimb as a join ers_users as x on a.b_role_id = x.r_id, a.b_resolver_id = x.r_id, "
				+ "join ers_status on a.b_status_id = ers_status.s_id, join ers_type on a.b_trype_id = ers_type.t_id where a.e_id = ? ";   	
		ErsReimbursement reim = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id1 = rs.getInt("b_id");
				Double amount = rs.getDouble("b_amount");
				Timestamp submitted = rs.getTimestamp("b_submitted");
				Timestamp resolved = rs.getTimestamp("b_resolved");
				String description = rs.getString("b_description");
				Blob receipt = rs.getBlob("b_receipt");
				int statusId = rs.getInt("s_id");
				String status = rs.getString("s_status");
				int typeId = rs.getInt("t_id");
				String type = rs.getString("t_type");
				int authorId = rs.getInt("e_id");
				String afirstname = rs.getString("e_firstname");
				String alastname = rs.getString("e_lastname");
				String ausername = rs.getString("e_username");  
				String aemail = rs.getString("e_email");
//				int roleId = rs.getInt("r_id");                                       //TODO do we need role?
//				String role = rs.getString("r_role");
				int resolverId = rs.getInt("e_id");                                 //TODO how to distinguish between the two users
				String rfirstname = rs.getString("e_firstname");
				String rlastname = rs.getString("e_lastname");
				String rusername = rs.getString("e_username");   				
  

				reim = new ErsReimbursement(id1, amount, submitted, resolved, description, receipt, new ErsUsers(authorId,ausername,null, afirstname, alastname, aemail, null), 
						new ErsUsers(resolverId,rusername,null, rfirstname, rlastname, null, null), new ErsStatus(statusId, status), new ErsType(typeId, type));    

				
			}
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return reim;
	}

	@Override
	public int add(ErsReimbursement reim) {
		int genId = -1;
		String sql = "insert into ers_reimb (b_amount, b_submitted, b_resolved, b_description, b_receipt, b_author_id, b_resolver_id, b_status_id, b_type_id) "
				+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?) returning e_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setDouble(1, reim.getAmount());
			ps.setTimestamp(2, reim.isSubmitted());
			ps.setTimestamp(3, reim.isResolved());
			ps.setString(4, reim.getDescription());
			ps.setBlob(5, reim.getRecipt());
			ps.setInt(6, reim.getAuthor().getId());              
			ps.setInt(7, reim.getResolver().getId()); 
			ps.setInt(8, reim.getErsStatus().getId()); 
			ps.setInt(9, reim.getErsType().getId());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				genId = rs.getInt("e_id");
			}
			
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
	
		return genId;
	}

	@Override
	public boolean update(ErsReimbursement reim) {
		String sql = "update ers_reimb set b_amount = ?, b_submitted = ?, b_resolved = ?, b_description = ?, b_receipt = ?, "
				+ "b_author_id = ?,  b_resolver_id = ?, b_status_id = ?, b_type_id = ?" + "Where b_id = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setDouble(1, reim.getAmount());
			ps.setTimestamp(2, reim.isSubmitted());
			ps.setTimestamp(3, reim.isResolved());
			ps.setString(4, reim.getDescription());
			ps.setBlob(5, reim.getRecipt());
			ps.setInt(6, reim.getAuthor().getId());              
			ps.setInt(7, reim.getResolver().getId()); 
			ps.setInt(8, reim.getErsStatus().getId()); 
			ps.setInt(9, reim.getErsType().getId());
			ps.setInt(10, reim.getId());
			
			rowsChanged = ps.executeUpdate();
			
		}catch (SQLException | IOException e) {
				e.printStackTrace();
			}
		if (rowsChanged > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<ErsReimbursement> getResolved() {
		String sql = "select * from ers_reimb join ers_status on ers_reimb.b_status_id = ers_status.s_id where ers_status.s_status = 'Resolved';";                
		List<ErsReimbursement> reimbs = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			Statement ps = connect.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				int id1 = rs.getInt("b_id");
				Double amount = rs.getDouble("b_amount");
				Timestamp submitted = rs.getTimestamp("b_submitted");
				Timestamp resolved = rs.getTimestamp("b_resolved");
				String description = rs.getString("b_description");
				Blob receipt = rs.getBlob("b_receipt");
				int userId = rs.getInt("b_author_id");
				int resolvedId = rs.getInt("b_resolved_id");
				
				ErsReimbursement emp = new ErsReimbursement(id1, amount, submitted, resolved, description, receipt, new ErsUsers(userId,null, null, null, null, null, null), 
						new ErsUsers(resolvedId,null, null, null, null, null, null), null, null);    
				reimbs.add(emp);
				}
		
		} catch (SQLException |IOException e) {
			log.error("Error while trying to get item.");
			e.printStackTrace();
		} 
	return reimbs;
	}

	@Override
	public List<ErsReimbursement> getAllForEmployee(int EmployeeId) {
		String sql = "select * from ers_reimb join ers_users on ers_reimb.b_author_id = ers_users.e_id where ers_users.e_id = ?;";                
		List<ErsReimbursement> reimbs = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, EmployeeId);
			ResultSet rs = ps.executeQuery();
			
			
			
			while (rs.next()) {
				int id1 = rs.getInt("b_id");
				Double amount = rs.getDouble("b_amount");
				Timestamp submitted = rs.getTimestamp("b_submitted");
				Timestamp resolved = rs.getTimestamp("b_resolved");
				String description = rs.getString("b_description");
				Blob receipt = rs.getBlob("b_receipt");
				int userId = rs.getInt("b_author_id");
				int resolvedId = rs.getInt("b_resolved_id");
				int statusId = rs.getInt("b_status_id");
				int typeId = rs.getInt("b_status_id");
				
				ErsReimbursement emp = new ErsReimbursement(id1, amount, submitted, resolved, description, receipt, new ErsUsers(userId,null, null, null, null, null, null), 
						new ErsUsers(resolvedId,null, null, null, null, null, null), new ErsStatus(statusId,null), new ErsType(typeId, null));    
				reimbs.add(emp);
				}
		
		} catch (SQLException |IOException e) {
			log.error("Error while trying to get item.");
			e.printStackTrace();
		} 
	return reimbs;
	}

		

}
