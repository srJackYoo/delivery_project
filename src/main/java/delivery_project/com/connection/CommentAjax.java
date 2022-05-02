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

import delivery_project.com.dao.CommentDao;
import delivery_project.com.vo.CommentVo;


@WebServlet("/comment/comment_ajax.do")
public class CommentAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment_num=request.getParameter("comment_num");
		CommentDao comDao=new CommentDao();
		response.setContentType("application/json;charset=UTF-8;");
		System.out.println(comment_num);
		try {
			if(comment_num==null) {
				response.getWriter().append(comDao.list(0).toString());				
			}else {
				response.getWriter().append(comDao.detail(Integer.parseInt(comment_num)).toString());
			}
		} catch (ClassNotFoundException | IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  StringBuffer json_str=new StringBuffer(); 
		  BufferedReader br=request.getReader(); String line="";
		  while((line=br.readLine())!=null) {
			  json_str.append(line); 
		  } 
		  JSONObject json=new JSONObject(json_str.toString());
		  System.out.println(line); 
		  CommentVo com=new CommentVo();
		  com.setComment_num(Integer.parseInt( json.getString("comment_num")));
		  com.setTitle(json.getString("title"));
		  com.setContents(json.getString("contents"));
		  com.setMember_id(json.getString("member_id"));
		  com.setImg(json.getString("img"));
		  com.setDelivery_grade(Byte.parseByte(json.getString("delivery_grade")));
		  com.setItem_grade(Byte.parseByte(json.getString("item_grade")));
		  com.setSeller_grade(Byte.parseByte(json.getString("seller_grade")));
		  com.setMenu_num(Integer.parseInt(json.getString("menu_num")));
		  com.setState(Byte.parseByte(json.getString("state")));
		  System.out.println("comment="+com);
		  
		  boolean update=false; 
		  CommentDao comDao=new CommentDao(); 
		  try {
			  update=comDao.update(com); 
		  }catch (ClassNotFoundException | SQLException e){ 
			  e.printStackTrace();
		  }
		  
		  response.getWriter().append("{\"update\":"+update+"}");
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comment_num=request.getParameter("comment_num");
		response.setContentType("application/json;charset=UTF-8;");
		boolean delete=false;
		CommentDao comDao=new CommentDao();
		try {
			delete=comDao.delete(Integer.parseInt(comment_num));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.getWriter().append("{\"delete\":"+delete+"}");
	}

}
