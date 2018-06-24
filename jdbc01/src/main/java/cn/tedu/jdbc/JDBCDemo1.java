package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo1 {
	public static void main(String[] args) throws Exception {
		//1. 注册驱动
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取数据连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		//System.out.println(conn);
		//3.创建SQL执行对象
		Statement stat = conn.createStatement();
		//4.执行SQL 
		//执行DDL使用execute(),
		//执行DML使用executeUpdate()
		//执行DQL使用executeQuery()
		//String sql = "create table jdbct1(id int, name varchar(10))";
		String sql = "create table if not exists jdbct2(id int, name varchar(10))";
		stat.execute(sql);
		stat.close();
		conn.close();
		
		
		
	}
}
