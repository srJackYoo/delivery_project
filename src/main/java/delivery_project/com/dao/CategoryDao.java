package delivery_project.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery_project.com.vo.CategoryVo;

public class CategoryDao implements CategoryDaoAble {
	private String list_sql = "SELECT * FROM FOOD_CATEGORY";
	private String detail_sql = "SELECT * FROM FOOD_CATEGORY WHERE cate_num=?";
	private String update_sql = "UPDATE FOOD_CATEGORY SET"
			+ " sell_type=?"
			+ " sub=?"
			+ " WHERE cate_num=?";
	private String delete_sql = "DELETE FROM FOOD_CATEGORY WHERE cate_num=?";
	private String insert_sql = "INSERT INTO FOOD_CATEGORY(sell_type, sub) VALUES(?,?)";
	public List<CategoryVo> list(int page) throws ClassNotFoundException, SQLException {
		List<CategoryVo> cate_list = new ArrayList<CategoryVo>();
		Connection conn = DeliveryConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(list_sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			CategoryVo cate = new CategoryVo();
			cate.setCate_num(rs.getInt("cate_num"));
			cate.setSell_type(rs.getString("sell_type"));
			cate.setSub(rs.getInt("sub"));
			cate_list.add(cate);
		}
		return cate_list;
	}
	public CategoryVo detail(int cate_num) throws ClassNotFoundException, SQLException {
		Connection conn = DeliveryConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(detail_sql);
		ps.setInt(1, cate_num);
		ResultSet rs = ps.executeQuery();
		CategoryVo cate = new CategoryVo();
		while(rs.next()) {
			cate.setCate_num(rs.getInt("cate_num"));
			cate.setSell_type(rs.getString("sell_type"));
			cate.setSub(rs.getInt("sub"));
		}
		return cate;
	}
	public boolean insert(CategoryVo cate) throws ClassNotFoundException, SQLException {
		Connection conn = DeliveryConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(insert_sql);
		ps.setString(1, cate.getSell_type());
		ps.setInt(2, cate.getSub());
		ps.setInt(3, cate.getCate_num());
		int insert = ps.executeUpdate();
		if(insert>0) {
			return true;
		}
		return false;
	}
	public boolean update(CategoryVo cate) throws ClassNotFoundException, SQLException {
		Connection conn = DeliveryConnection.getConnection();
		PreparedStatement ps = conn.prepareStatement(update_sql);
		ps.setString(1, cate.getSell_type());
		ps.setInt(2, cate.getSub());
		ps.setInt(3, cate.getCate_num());
		int update = ps.executeUpdate();
		if(update>0) {
			return true;
		}
		return false;
	}
	public boolean delete(int cate_num) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
