package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//import javax.management.relation.Role;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.models.ErsRoles;
import com.revature.models.ErsUsers;
import com.revature.util.ConnectionUtil;


public class UserPostgres implements UserDao{
	private static Logger log = LogManager.getRootLogger();
	
	@Override
	public List<ErsUsers> getAll() {
		String sql = "select * from ers_users join ers_roles on ers_users.e_role_id = ers_roles.r_id;";                
		List<ErsUsers> users = new ArrayList<>();
		
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

				
				ErsUsers emp = new ErsUsers(id, firstName, lastName,username,password,email, new ErsRoles(roleId,role));    
				users.add(emp);
				}
		
		} catch (SQLException |IOException e) {
			log.error("Error while trying to get item.");
			e.printStackTrace();
		} 
	return users;
	}

	@Override
	public ErsUsers getById(int id) {
		String sql = "select * from ers_users join ers_roles on ers_users.e_role_id = ers_roles.r_id where e_id = ? ";   	
		ErsUsers emp = null;
		
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

				
				emp = new ErsUsers(id, firstName, lastName,username,password,email, new ErsRoles(roleId,role));    

				
			}
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int add(ErsUsers user) {
		int genId = -1;
		String sql = "insert into ers_users (e_username, e_password, e_firstname, e_lastname, e_email, e_role_id) "
				+ "values (?, ?, ?, ?, ?, ?) returning e_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRole().getId());
			
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
	public boolean update(ErsUsers user) {
		String sql = "update ers_users set e_first_name = ?, e_last_name = ?, e_username = ?, e_password = ?, e_email = ?, e_role_id = ?" + "Where e_id = ?;";
		int rowsChanged = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setInt(6, user.getRole().getId());              
			
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
	public ErsUsers getUserByUsernameAndPassword(String username, String password) {
		
		String sql = "select * from ers_users join ers_roles on ers_users.e_role_id = ers_roles.r_id where e_username = ? and e_password = ?;";   	
		ErsUsers emp = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()) {
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, username);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int id1 = rs.getInt("u_id");
				String firstName = rs.getString("e_first_name");
				String lastName = rs.getString("e_last_name");
				String username1 = rs.getString("e_username");
				String password1 = rs.getString("e_password");
				String email = rs.getString("e_email");
				int roleId = rs.getInt("r_id");
				String role = rs.getString("r_role");

				
				emp = new ErsUsers(id1, firstName, lastName,username1,password1,email, new ErsRoles(roleId,role));    

				
			}
		}catch (SQLException | IOException e) {
			e.printStackTrace();
		}
		return emp;
	}

	


}
