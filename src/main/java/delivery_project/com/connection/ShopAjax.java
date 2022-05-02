package delivery_project.com.connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import delivery_project.com.dao.ShopDao;
import delivery_project.com.vo.ShopListVo;

/**
 * Servlet implementation class ShopAjax
 */
@WebServlet("/shop/ajax.do")
public class ShopAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String shop_num = request.getParameter("shop_num");
		ShopDao shopDao = new ShopDao();
		response.setContentType("application/json; charset=UTF-8;");
		try {
			if(shop_num==null) {
				response.getWriter().append(shopDao.list(0).toString());
			}else {
				response.getWriter().append(shopDao.detail(Integer.parseInt(shop_num)).toString());
			}
			
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		String line = null;
		BufferedReader reader = request.getReader();
		while((line=reader.readLine())!=null) {
			jb.append(line);
		}
		JSONObject json = new JSONObject(jb.toString());
		
		ShopListVo shop = new ShopListVo();
		shop.setSeller_id(json.getString("seller_id"));
		shop.setShop_name(json.getString("shop_name"));
		shop.setLocation(json.getString("location"));
		shop.setShop_phone(json.getString("shop_phone"));
		shop.setUpdate_month(Integer.parseInt(json.getString("update_month")));
		shop.setOpen_time(json.getString("open_time"));
		shop.setClose_time(json.getString("close_time"));
		shop.setSell_type(json.getString("sell_type"));
		
		boolean insert = false;
		ShopDao shopDao = new ShopDao();
		try {
			insert = shopDao.insert(shop);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("{\"insert\":"+insert+"}");
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer json_str = new StringBuffer();
		BufferedReader br = request.getReader();
		String line = "";
		while((line=br.readLine())!=null) {
			json_str.append(line);
		}
		JSONObject json = new JSONObject(json_str.toString());
		ShopListVo shop = new ShopListVo();
		shop.setShop_num(Integer.parseInt(json.get("shop_num").toString()));
		shop.setSeller_id(json.getString("seller_id"));
		shop.setShop_name(json.getString("shop_name"));
		shop.setLocation(json.getString("location"));
		shop.setShop_phone(json.getString("shop_phone"));
		shop.setUpdate_month(Integer.parseInt(json.getString("update_month")));
		shop.setOpen_time(json.getString("open_time"));
		shop.setClose_time(json.getString("close_time"));
		shop.setSell_type(json.getString("sell_type"));
		
		boolean update = false;
		ShopDao shopDao = new ShopDao();
		try {
			update = shopDao.update(shop);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("{\"update\":"+update+"}");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
