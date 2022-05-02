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

import delivery_project.com.dao.MenuDao;
import delivery_project.com.vo.MenuVo;


@WebServlet("/menu/menu_ajax.do")
public class MenuAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu_num=request.getParameter("menu_num");
		MenuDao menuDao=new MenuDao();
		response.setContentType("application/json;charset=UTF-8;");
		System.out.println(menu_num);
		try {
			if(menu_num==null) {
				response.getWriter().append(menuDao.list(0).toString());				
			}else {
				response.getWriter().append(menuDao.detail(Integer.parseInt(menu_num)).toString());
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		String line = null;
		BufferedReader reader = request.getReader();
		while ((line = reader.readLine()) != null){
			jb.append(line);			
		}
		JSONObject json= new JSONObject(jb.toString());
		
		MenuVo menu=new MenuVo();
		menu.setName(json.getString("name"));
		menu.setPrice(Integer.parseInt( json.getString("price") ));
		menu.setMenu_detail(json.getString("menu_detail"));
		menu.setMenu_img(json.getString("menu_img"));
		menu.setDetail_img(json.getString("detail_img"));
		menu.setShop_num(Integer.parseInt( json.getString("shop_num") ));
		System.out.println(menu);

		boolean insert=false;
		MenuDao menuDao=new MenuDao();
		try {
			insert=menuDao.insert(menu);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("{\"insert\":"+insert+"}");
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer json_str=new StringBuffer();
		BufferedReader br=request.getReader();
		String line="";
		while((line=br.readLine())!=null) {
			json_str.append(line);
		}
		JSONObject json=new JSONObject(json_str.toString());
		System.out.println(line);
		MenuVo menu=new MenuVo();
		menu.setMenu_num(Integer.parseInt( json.getString("menu_num")));
		menu.setName(json.getString("name"));
		menu.setPrice(Integer.parseInt( json.getString("price") ));
		menu.setMenu_detail(json.getString("menu_detail"));
		menu.setMenu_img(json.getString("menu_img"));
		menu.setDetail_img(json.getString("detail_img"));
		menu.setShop_num(Integer.parseInt( json.getString("shop_num") ));
		System.out.println("menu="+menu);
		
		boolean update=false;
		MenuDao menuDao=new MenuDao();
		try {
			update=menuDao.update(menu);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("{\"update\":"+update+"}");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String menu_num=request.getParameter("menu_num");
		response.setContentType("application/json;charset=UTF-8;");
		boolean delete=false;
		MenuDao menuDao=new MenuDao();
		try {
			delete=menuDao.delete(Integer.parseInt(menu_num));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("{\"delete\":"+delete+"}");
	}

}
