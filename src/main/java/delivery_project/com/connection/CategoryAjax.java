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

import delivery_project.com.dao.CategoryDao;
import delivery_project.com.vo.CategoryVo;

@WebServlet("/cate/category_ajax.do")
public class CategoryAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cate_num = request.getParameter("cate_num");
		CategoryDao cateDao = new CategoryDao();
		response.setContentType("application/json; charset=UTF-8;");
		try {
			if(cate_num == null) {
				response.getWriter().append(cateDao.list(0).toString());
			}else {
				response.getWriter().append(cateDao.detail(Integer.parseInt(cate_num)).toString());
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer jb = new StringBuffer();
		String line = null;
		BufferedReader reader = request.getReader();
		while((line = reader.readLine()) != null) {
			jb.append(line);
		}
		JSONObject json = new JSONObject(jb.toString());
		
		CategoryVo cate = new CategoryVo();
		cate.setCate_num(Integer.parseInt(json.getString("cate_num")));
		cate.setSell_type(json.getString("sell_type"));
		cate.setSub(Integer.parseInt(json.getString("sub")));
		
		boolean insert = false;
		CategoryDao cateDao = new CategoryDao();
		try {
			insert = cateDao.insert(cate);
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
		
		CategoryVo cate = new CategoryVo();
		cate.setCate_num(Integer.parseInt(json.getString("cate_num")));
		cate.setSell_type(json.getString("sell_type"));
		cate.setSub(Integer.parseInt(json.getString("sub")));
		
		boolean update = false;
		CategoryDao cateDao = new CategoryDao();
		try {
			update = cateDao.update(cate);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().append("{\"update\":"+update+"}");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
