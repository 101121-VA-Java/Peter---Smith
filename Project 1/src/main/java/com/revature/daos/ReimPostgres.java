package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.ErsReimbursement;
import com.revature.models.ErsRoles;
import com.revature.models.ErsUsers;
import com.revature.util.ConnectionUtil;

public class ReimPostgres implements GenericDao<ErsReimbursement>{
	private static Logger log = LogManager.getRootLogger();
	
	@Override
	public List<ErsReimbursement> getAll() {
		String sql = "select * from ers_reimb join ers_users on ers_users.e_role_id = ers_roles.r_id;";                
		List<ErsReimbursement> reimbs = new ArrayList<>();
		
		try (Connection connect = ConnectionUtil.getConnectionFromFile()) {
			Statement ps = connect.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt("u_id");
				String firstName = rs.getString("u_first_name");
				String lastName = rs.getString("u_last_name");
				String username = rs.getString("u_username");
				String password = rs.getString("u_password");
				String email = rs.getString("u_email");
				int roleId = rs.getInt("r_id");
				String role = rs.getString("r_role");

				
//				ErsReimbursement emp = new ErsReimbursement(id, amount, submitted, resolved, description, email, receipt, new ErsUsers(roleId,role));    
//				reimbs.add(emp);
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
				int id1 = rs.getInt("u_id");
				String firstName = rs.getString("e_first_name");
				String lastName = rs.getString("e_last_name");
				String username = rs.getString("e_username");
				String password = rs.getString("e_password");
				String email = rs.getString("e_email");
				int roleId = rs.getInt("r_id");
				String role = rs.getString("r_role");

				
//				reim = new ErsReimbursement(id, firstName, lastName,username,password,email, new ErsRoles(roleId,role));    

				
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
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
