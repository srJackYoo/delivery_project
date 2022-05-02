package delivery_project.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DeliveryConnection {
	static final private String url = "jdbc:mysql://localhost:3306/delivery_project";
	static final private String user = "root";
	static final private String pw = "mysql";
	static final private String driver = "com.mysql.cj.jdbc.Driver";
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		Class.forName(driver);
		conn = DriverManager.getConnection(url,user,pw);
		
		return conn;
		
	}
}
