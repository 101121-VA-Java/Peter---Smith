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
		String sql = "insert into bids (e_price, e_bidder_id, e_item_id) "
				+ "values (?, ?, ?) returning e_id;";
		
		try(Connection con = ConnectionUtil.getConnectionFromFile()){
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, t.getPrice());
			ps.setInt(2, t.getBidderId());
			ps.setInt(3, t.getItemId());
			
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

				
				bid = new Bid(id, price, bidderid, itemid); 

				bidders.add(bid);
			}
		} catch (SQLException | IOException e) {
			e.printStackTrace();
		} 
		return bidders;	
	}

	@Override
	public Bid getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Bid t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
