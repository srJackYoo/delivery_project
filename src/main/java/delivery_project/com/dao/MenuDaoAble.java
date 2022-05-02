package delivery_project.com.dao;

import java.sql.SQLException;
import java.util.List;

import delivery_project.com.vo.MenuVo;

public interface MenuDaoAble {
	public List<MenuVo> list(int page) throws ClassNotFoundException, SQLException; 
	public MenuVo detail(int menu_num) throws ClassNotFoundException, SQLException; 
	public boolean insert(MenuVo menu) throws ClassNotFoundException, SQLException; 
	public boolean update(MenuVo menu) throws ClassNotFoundException, SQLException; 
	public boolean delete(int menu_num) throws ClassNotFoundException, SQLException; 

}
