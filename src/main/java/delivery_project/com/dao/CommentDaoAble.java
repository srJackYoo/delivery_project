package delivery_project.com.dao;

import java.sql.SQLException;
import java.util.List;

import delivery_project.com.vo.CommentVo;

public interface CommentDaoAble {
	public List<CommentVo> list(int page) throws ClassNotFoundException, SQLException;
	public CommentVo detail(int comment_num) throws ClassNotFoundException, SQLException;
	public boolean update(CommentVo com) throws ClassNotFoundException, SQLException;
	public boolean delete(int comment_num) throws ClassNotFoundException, SQLException;
}
