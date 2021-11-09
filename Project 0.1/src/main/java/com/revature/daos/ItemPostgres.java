package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Item;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class ItemPostgres implements GenericDao<Item> {

	@Override
	public int add(Item t) {
		int genId = -1;
		String sql = "insert into items (e_price, e_name, e_description, e_owned) "
				+ "values (?, ?, ?, ?) returning e_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, t.getPrice());
			ps.setString(2, t.getName());
			ps.setString(3, t.getDescription());
			ps.setBoolean(4, t.isOwned());
			
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
	public List<Item> getAll() {
		
		Item itm = null;
		String sql = "select * from items;";
		List<Item> employees = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("e_id");
				int price = rs.getInt("e_price");
				String name = rs.getString("e_name");
				String description = rs.getString("e_description");
				Boolean owned = rs.getBoolean("e_owned");
				
				itm = new Item(id, price, name, description, owned); 

				employees.add(itm);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return employees;	
		
		
	}

	@Override
	public Item getById(int id) {
		String sql = "select * from items where e_id = ? ";
		Item itm = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); 	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int e_id = rs.getInt("e_id");
				int price = rs.getInt("e_price");
				String name = rs.getString("e_name");
				String description = rs.getString("e_description");
				Boolean owned = rs.getBoolean("e_owned");

				
				itm = new Item(e_id, price, name, description, owned); 

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return itm;
	}

	@Override
	public boolean update(Item t) {
		String sql = "update items set e_price=?, e_name=?, e_description=?, e_owned=? where e_id = ?;";

		int rs = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getPrice());
			ps.setString(2, t.getName());
			ps.setString(3, t.getDescription());
			ps.setBoolean(4, t.isOwned());
			ps.setInt(5, t.getId()); 
			
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
	
		String sql = "delete from items where e_id = ? ";

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
