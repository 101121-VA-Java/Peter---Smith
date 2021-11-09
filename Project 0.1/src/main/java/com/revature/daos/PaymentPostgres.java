package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Payment;
import com.revature.util.ConnectionUtil;

public class PaymentPostgres implements GenericDao<Payment>{

	@Override
	public int add(Payment t) {
		int genId = -1;
		String sql = "insert into payments (e_item_id, e_user_id, e_payment, e_remaining_balance, e_last_payment_date) "
				+ "values (?, ?, ?, ?, ?) returning e_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, t.getItemId());
			ps.setInt(2, t.getUserId());
			ps.setInt(3, t.getPayment());
			ps.setInt(4, t.getRemainingBalance());
			ps.setObject(5, t.getLastPaymentDate());
			
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
	public List<Payment> getAll() {
		
		Payment pay = null;
		String sql = "select * from payments;";
		List<Payment> payments = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("e_id");
				int itemid = rs.getInt("e_item_id");
				int userid = rs.getInt("e_user_id");
				int payment = rs.getInt("e_payment");
				int balance = rs.getInt("e_remaining_balance");
				LocalDate date = rs.getDate("e_last_payment_date").toLocalDate();
				
				pay = new Payment(id, itemid, userid, payment, balance, date); 

				payments.add(pay);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return payments;	
	}

	@Override
	public Payment getById(int id) {
		
		String sql = "select * from payments where e_id = ? ";
		Payment pay = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); 	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int e_id = rs.getInt("e_id");
				int itemid = rs.getInt("e_item_id");
				int userid = rs.getInt("e_user_id");
				int payment = rs.getInt("e_payment");
				int balance = rs.getInt("e_remaining_balance");
				LocalDate date = rs.getDate("e_last_payment_date").toLocalDate();
				
				pay = new Payment(id, itemid, userid, payment, balance, date); 

				
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return pay;
	}

	@Override
	public boolean update(Payment t) {
		String sql = "update bids set e_item_id=?, e_user_id=?, e_payment=?, e_remaining_balance=?, e_last_payment_date=? where e_id = ?;";

		int rs = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getItemId());
			ps.setInt(2, t.getUserId());
			ps.setInt(3, t.getPayment());
			ps.setInt(4, t.getRemainingBalance());
			ps.setObject(5, t.getLastPaymentDate());
			ps.setInt(6, t.getId()); 
			
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
		String sql = "delete from payments where e_id = ? ";

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
