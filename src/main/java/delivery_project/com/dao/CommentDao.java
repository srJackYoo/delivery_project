package delivery_project.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import delivery_project.com.vo.CommentVo;

public class CommentDao implements CommentDaoAble {
	private String list_sql="SELECT * FROM COMMENT";
	private String detail_sql="SELECT * FROM COMMENT WHERE comment_num=?";
	private String update_sql="UPDATE COMMENT SET "
			+ " state=? "
			+ " WHERE comment_num=?";
	private String delete_sql="DELETE FROM COMMENT WHERE comment_num=?";
	@Override
	public List<CommentVo> list(int page) throws ClassNotFoundException, SQLException {
		List<CommentVo> com_list=new ArrayList<CommentVo>();
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(list_sql);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			CommentVo com=new CommentVo();
			com.setComment_num(rs.getInt("comment_num"));
			com.setTitle(rs.getString("title"));
			com.setContents(rs.getString("contents"));
			com.setImg(rs.getString("img"));
			com.setPost_time(rs.getDate("post_time"));
			com.setDelivery_grade(rs.getByte("delivery_grade"));
			com.setItem_grade(rs.getByte("item_grade"));
			com.setSeller_grade(rs.getByte("seller_grade"));
			com.setMenu_num(rs.getInt("menu_num"));
			com.setMember_id(rs.getString("member_id"));
			com.setState(rs.getByte("state"));
			com_list.add(com);
		}
		return com_list;
	}

	@Override
	public CommentVo detail(int comment_num) throws ClassNotFoundException, SQLException {
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(detail_sql);
		ps.setInt(1, comment_num);
		ResultSet rs=ps.executeQuery();
		CommentVo com=new CommentVo();
		while(rs.next()) {
			com.setComment_num(rs.getInt("comment_num"));
			com.setTitle(rs.getString("title"));
			com.setMember_id(rs.getString("member_id"));
			com.setMenu_num(rs.getInt("menu_num"));
			com.setContents(rs.getString("contents"));
			com.setImg(rs.getString("img"));
			com.setDelivery_grade(rs.getByte("delivery_grade"));
			com.setItem_grade(rs.getByte("item_grade"));
			com.setSeller_grade(rs.getByte("seller_grade"));
			com.setPost_time(rs.getDate("post_time"));
			com.setState(rs.getByte("state"));
		}
		return com;
	}

	@Override
	public boolean update(CommentVo com) throws ClassNotFoundException, SQLException {
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(update_sql);
		ps.setByte(1, com.getState());
		ps.setInt(2, com.getComment_num());
		int update=ps.executeUpdate(); 
		if(update>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int comment_num) throws ClassNotFoundException, SQLException {
		Connection conn=DeliveryConnection.getConnection();
		PreparedStatement ps=conn.prepareStatement(delete_sql);
		ps.setInt(1, comment_num);
		int delete=ps.executeUpdate(); 
		if(delete>0) {
			return true;
		}else {			
			return false;
		}
	}
	
}
