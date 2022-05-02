package delivery_project.com.dao;

import java.sql.SQLException;
import java.util.List;

import delivery_project.com.vo.ShopListVo;

public interface ShopDaoAble {
	public List<ShopListVo> list(int page) throws SQLException, ClassNotFoundException;
	public ShopListVo detail(int shop_num) throws SQLException, ClassNotFoundException;
	public boolean insert(ShopListVo shop) throws SQLException, ClassNotFoundException;
	public boolean update(ShopListVo shop) throws SQLException, ClassNotFoundException;
	public boolean delete(int num) throws SQLException, ClassNotFoundException;
}
