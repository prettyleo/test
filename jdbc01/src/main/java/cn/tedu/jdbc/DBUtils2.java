package cn.tedu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtils2 {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static{
		Properties pro = new Properties();
		InputStream is = DBUtils2.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			pro.load(is);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**  
	 *获取连接的方法
	 */  
	public static Connection getConn() throws Exception{
		
		//1.注册驱动
		Class.forName(driver);
		//2.获取连接对象
		Connection conn = DriverManager.getConnection(url,username,password);
		return conn;
	}
	
	/**  
	 *关闭对象的顺序,按照先创建后关闭的顺序.先关rs->stat->conn
	 */  
	public static void close(ResultSet rs, Statement stat, Connection conn){
		try {
			//避免空指针异常
			if(rs!=null){
				rs.close();
			}
			if(stat!=null){
				stat.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
