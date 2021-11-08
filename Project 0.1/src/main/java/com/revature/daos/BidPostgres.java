package com.revature.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Bid;
import com.revature.models.Item;
import com.revature.util.ConnectionUtil;

public class BidPostgres implements GenericDao<Bid>{

	@Override
	public int add(Bid t) {
		int genId = -1;
		String sql = "insert into bids (e_price, e_bidder_id, e_item_id, e_bid_status) "
				+ "values (?, ?, ?, ?) returning e_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, t.getPrice());
			ps.setInt(2, t.getBidderId());
			ps.setInt(3, t.getItemId());
			ps.setInt(4, t.getBidStatus());
			
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
	public List<Bid> getAll() {
		Bid bid = null;
		String sql = "select * from bids;";
		List<Bid> bidders = new ArrayList<>();
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			
			while(rs.next()) {
				int id = rs.getInt("e_id");
				int price = rs.getInt("e_price");
				int bidderid = rs.getInt("e_bidder_id");
				int itemid = rs.getInt("e_item_id");
				int bidstatus = rs.getInt("e_bid_status");
				
				bid = new Bid(id, price, bidderid, itemid, bidstatus); 

				bidders.add(bid);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return bidders;	
	}

	@Override
	public Bid getById(int id) {
		String sql = "select * from bids where e_id = ? ";
		Bid itm = null;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id); 	
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int e_id = rs.getInt("e_id");
				int price = rs.getInt("e_price");
				int bidderid = rs.getInt("e_bidder_id");
				int itemid = rs.getInt("e_item_id");
				int bidstatus = rs.getInt("e_bid_status");

				
				itm = new Bid(e_id, price, bidderid, itemid, bidstatus); 

			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return itm;
	}

	@Override
	public boolean update(Bid t) {
	
		String sql = "update bids (e_price=?, e_bidder_id=?, e_item_id=?, e_bid_status=? where e_id = ?);";
//				+ "returning e_id;";
		
		int rs = -1;
		
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, t.getPrice());
			ps.setInt(2, t.getBidderId());
			ps.setInt(3, t.getItemId());
			ps.setInt(4, t.getBidStatus());
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
		String sql = "delete from bids where e_id = ? ";

		int result = -1;
			
		try (Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
				
			ps.setInt(1, id); // 1 refers to the first '?'	
				
			result = ps.executeUpdate();
				
				
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return result;
	}

	
}
