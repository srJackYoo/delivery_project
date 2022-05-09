package delivery_project.com.dao;

import java.sql.SQLException;
import java.util.List;

import delivery_project.com.vo.CategoryVo;

public interface CategoryDaoAble {
	public List<CategoryVo> list(int page) throws ClassNotFoundException, SQLException;
	public CategoryVo detail(int cate_num) throws ClassNotFoundException, SQLException;
	public boolean insert(CategoryVo cate) throws ClassNotFoundException, SQLException;
	public boolean update(CategoryVo cate) throws ClassNotFoundException, SQLException;
	public boolean delete(int cate_num) throws ClassNotFoundException, SQLException;
}
