package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo2 {
	
	@Test
	public void testDrop() throws Exception{
		//1.注册
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		//3.获取SQL执行对象
		Statement stat = conn.createStatement();
		//4.执行SQL
		stat.execute("drop table if exists jdbct2");
		System.out.println("删除成功!");
		//5.关闭资源
		stat.close();
		conn.close();
	}
	@Test
	public void testInsert() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		//3.获取SQL执行对象
		Statement stat = conn.createStatement();
		//4.执行SQL
		String sql = "insert into jdbct1 values(1,'Tom')";
		stat.executeUpdate(sql);
		System.out.println("插入成功!");
		//5.关闭资源
		stat.close();
		conn.close();
	}
	@Test
	public void testSelect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		//2.获取连接对象
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		//3.获取SQL执行对象
		Statement stat = conn.createStatement();
		//4.执行SQL
		ResultSet rs = stat.executeQuery("select * from jdbct1");
		//遍历结果
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id+":"+name);
		}
		//5.关闭资源
		stat.close();
		conn.close();
	}
	
}
