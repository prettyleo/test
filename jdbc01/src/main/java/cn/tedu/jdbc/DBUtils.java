package cn.tedu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

public class DBUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	private static Connection conn;
	
	static{
		Properties pro = new Properties();
		InputStream is = DBUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
		try {
			pro.load(is);
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
			//以下代码用来获取连接池
			BasicDataSource bds = new BasicDataSource();
			bds.setDriverClassName(driver);
			bds.setUrl(url);
			bds.setUsername(username);
			bds.setPassword(password);
			bds.setInitialSize(3);
			bds.setMaxActive(5);
			try {
				conn = bds.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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


	public static Connection getConn() {
		return conn;
	}
	
	
}
