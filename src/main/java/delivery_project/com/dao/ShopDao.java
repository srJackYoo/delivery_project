package delivery_project.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery_project.com.vo.ShopListVo;

public class ShopDao implements ShopDaoAble {
	private String list_sql = "SELECT * FROM SHOP_LIST";
	private String detail_sql = "SELECT * FROM SHOP_LIST WHERE shop_num=?";
	private String insert_sql = "INSERT INTO SHOP_LIST"
			+ "(seller_id, shop_name, location, shop_phone, update_month, open_time, close_time, sell_type)"
			+ "VALUES(?,?,?,?,?,?,?,?)";
	private String update_sql = "UPDATE SHOP_LIST SET shop_name=?, location=?, shop_phone=?, open_time=?, close_time=?, sell_type=? WHERE shop_num=?";
	@Override
	public List<ShopListVo> list(int page) throws SQLException, ClassNotFoundException {
		Connection conn = DeliveryConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(list_sql);
		ResultSet rs = ps.executeQuery();
		List<ShopListVo> shop_list = new ArrayList<ShopListVo>();
		while(rs.next()) {
			ShopListVo shop = new ShopListVo();
			shop.setShop_num(rs.getInt("shop_num"));
			shop.setSeller_id(rs.getString("seller_id"));
			shop.setShop_name(rs.getString("shop_name"));
			shop.setLocation(rs.getString("location"));
			shop.setShop_phone(rs.getString("shop_phone"));
			shop.setUpdate_month(rs.getInt("update_month"));
			shop.setOpen_time(rs.getString("open_time"));
			shop.setClose_time(rs.getString("close_time"));
			shop.setSell_type(rs.getString("sell_type"));
			shop_list.add(shop);
		}
		
		return shop_list;
	}

	@Override
	public ShopListVo detail(int shop_num) throws SQLException, ClassNotFoundException {
		Connection conn = DeliveryConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(detail_sql);
		ps.setInt(1, shop_num);
		ResultSet rs = ps.executeQuery();
		ShopListVo shop = new ShopListVo();
		if(rs.next()) {
			shop.setShop_num(rs.getInt("shop_num"));
			shop.setSeller_id(rs.getString("seller_id"));
			shop.setShop_name(rs.getString("shop_name"));
			shop.setLocation(rs.getString("location"));
			shop.setShop_phone(rs.getString("shop_phone"));
			shop.setUpdate_month(rs.getInt("update_month"));
			shop.setOpen_time(rs.getString("open_time"));
			shop.setClose_time(rs.getString("close_time"));
			shop.setSell_type(rs.getString("sell_type"));
		}
		return shop;
	}

	@Override
	public boolean insert(ShopListVo shop) throws SQLException, ClassNotFoundException {
		Connection conn = DeliveryConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(insert_sql);
		ps.setString(1, shop.getSeller_id());
		ps.setString(2, shop.getShop_name());
		ps.setString(3, shop.getLocation());
		ps.setString(4, shop.getShop_phone());
		ps.setInt(5, shop.getUpdate_month());
		ps.setString(6, shop.getOpen_time());
		ps.setString(7, shop.getClose_time());
		ps.setString(8, shop.getSell_type());
		int insert = ps.executeUpdate();
		if(insert>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(ShopListVo shop) throws SQLException, ClassNotFoundException {
		Connection conn = DeliveryConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(update_sql);
		ps.setString(1, shop.getShop_name());
		ps.setString(2, shop.getLocation());
		ps.setString(3, shop.getShop_phone());
		ps.setString(4, shop.getOpen_time());
		ps.setString(5, shop.getClose_time());
		ps.setString(6, shop.getSell_type());
		ps.setInt(7, shop.getShop_num());
		int update = ps.executeUpdate();
		if(update>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int num) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
