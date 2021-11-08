package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.*;
import com.revature.util.ConnectionUtil;

public class UserPostgres implements GenericDao<User> {

	@Override
	public int add(User employee) {
		int genId = -1;
		String sql = "insert into users (e_name, e_username, e_password, e_role, e_man_id) "
				+ "values (?, ?, ?, ?, ?) returning e_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getRole());
			ps.setInt(5, employee.getManagerid());
			
			ResultSet rs = ps.executeQuery();

			if(rs.next()) {
				genId = rs.getInt("e_id");
			}
			
		} catch (SQLException | IOException e) {
			
			e.printStackTrace();
		}
		
		return genId;
	
	}

//	@Override
	public User getById(int id) {
		
		String sql = "select * from employees where e_id = ? ";
		User emp = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); 	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int e_id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String e_username = rs.getString("e_username");
				String e_password = rs.getString("e_password");
				String role = rs.getString("e_role");
				int manager = rs.getInt("e_man_id");

				
				emp = new User(e_id, name, e_username, e_password, role, manager); 

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return emp;
	}

	@Override
	public List<User> getAll() {
		User emp = null;
		String sql = "select * from users;";
		List<User> employees = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("e_id");
				String name = rs.getString("e_name");
				String e_username = rs.getString("e_username");
				String e_password = rs.getString("e_password");
				String role = rs.getString("e_role");
				int manager = rs.getInt("e_man_id");
				
				emp = new User(id, name, e_username, e_password, role, manager); 

				employees.add(emp);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return employees;
	}

	

	@Override
	public boolean update(User employee) {
		
		String sql = "update users (e_name = ?, e_username = ?, e_password = ?, e_role = ?, e_man_id = ? from employees where e_id = ?;";
//		+ "returning e_id;";    TODO do i need?
		int rs = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, employee.getName());
			ps.setString(2, employee.getUsername());
			ps.setString(3, employee.getPassword());
			ps.setString(4, employee.getRole());
			ps.setInt(5, employee.getManagerid());
			ps.setInt(6, employee.getId()); 
			
			rs = ps.executeUpdate();
			

		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		if (rs > 0) {
			return true;
		}
		return false;
		
	}

	@Override
	public int delete(int id) {
		String sql = "delete from users where e_id = ? ";

		int result = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); 
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return result;
		
	}

}
