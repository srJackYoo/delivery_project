package delivery_project.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery_project.com.vo.MenuVo;

public class MenuDao implements MenuDaoAble {
	private String list_sql="SELECT * FROM MENU";
	private String detail_sql="SELECT * FROM MENU WHERE menu_num=?";
	private String update_sql="UPDATE MENU SET "
			+ " name=?,"
			+ " price=?,"
			+ " menu_detail=?,"
			+ " menu_img=?,"
			+ " detail_img=?,"
			+ " shop_num=? "
			+ " WHERE menu_num=?";
	private String delete_sql="DELETE FROM MENU WHERE menu_num=?";
	private String insert_sql="INSERT INTO MENU(name,price,menu_detail,menu_img,detail_img,shop_num) VALUES(?,?,?,?,?,?)";
	@Override
	public List<MenuVo> list(int page) throws ClassNotFoundException, SQLException {
		List<MenuVo> menu_list=new ArrayList<MenuVo>();
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			MenuVo menu=new MenuVo();
			menu.setMenu_num(rs.getInt("menu_num"));
			menu.setName(rs.getString("name"));
			menu.setPrice(rs.getInt("price"));
			menu.setMenu_detail(rs.getString("menu_detail"));
			menu.setMenu_img(rs.getString("menu_img"));
			menu.setDetail_img(rs.getString("detail_img"));
			menu.setPost_date(rs.getDate("post_date"));
			menu.setShop_num(rs.getInt("shop_num"));
			menu_list.add(menu);
		}
		return menu_list;
	}

	@Override
	public MenuVo detail(int menu_num) throws ClassNotFoundException, SQLException {
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setInt(1, menu_num);
		ResultSet rs=ps.executeQuery();
		MenuVo menu=new MenuVo();
		while(rs.next()) {
			menu.setMenu_num(rs.getInt("menu_num"));
			menu.setName(rs.getString("name"));
			menu.setPrice(rs.getInt("price"));
			menu.setMenu_detail(rs.getString("menu_detail"));
			menu.setMenu_img(rs.getString("menu_img"));
			menu.setDetail_img(rs.getString("detail_img"));
			menu.setPost_date(rs.getDate("post_date"));
			menu.setShop_num(rs.getInt("shop_num"));
		}
		return menu;
	}

	@Override
	public boolean insert(MenuVo menu) throws ClassNotFoundException, SQLException {
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(insert_sql);
		ps.setString(1, menu.getName());
		ps.setInt(2, menu.getPrice());
		ps.setString(3, menu.getMenu_detail());
		ps.setString(4, menu.getMenu_img());
		ps.setString(5, menu.getDetail_img());
		ps.setInt(6, menu.getShop_num());
		int insert=ps.executeUpdate();
		if(insert>0) {
			return true;
		}else {			
			return false;
		}
	}

	@Override
	public boolean update(MenuVo menu) throws ClassNotFoundException, SQLException {
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setString(1, menu.getName());
		ps.setInt(2, menu.getPrice());
		ps.setString(3, menu.getMenu_detail());
		ps.setString(4, menu.getMenu_img());
		ps.setString(5, menu.getDetail_img());
		ps.setInt(6, menu.getShop_num());
		ps.setInt(7, menu.getMenu_num());
	
		int update=ps.executeUpdate(); 
		if(update>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int menu_num) throws ClassNotFoundException, SQLException {
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setInt(1, menu_num);
		int delete=ps.executeUpdate(); 
		if(delete>0) {
			return true;
		}else {			
			return false;
		}
	}
	
}
