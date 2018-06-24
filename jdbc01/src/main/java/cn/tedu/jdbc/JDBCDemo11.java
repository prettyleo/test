package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo11 {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		Statement stat = conn.createStatement();
		String sql = "create table jdbct4(int id,name varchar(10))";
		stat.execute(sql);
		sql = "insert into jdbct4(1,'Leo')";
		stat.executeUpdate(sql);
		stat.close();
		conn.close();
		
	}
	
}
