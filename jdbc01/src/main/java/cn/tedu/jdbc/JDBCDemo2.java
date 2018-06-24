package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo2 {
	
	@Test
	public void testDrop() throws Exception{
		//1.ע��
		Class.forName("com.mysql.jdbc.Driver");
		//2.��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		//3.��ȡSQLִ�ж���
		Statement stat = conn.createStatement();
		//4.ִ��SQL
		stat.execute("drop table if exists jdbct2");
		System.out.println("ɾ���ɹ�!");
		//5.�ر���Դ
		stat.close();
		conn.close();
	}
	@Test
	public void testInsert() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		//2.��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		//3.��ȡSQLִ�ж���
		Statement stat = conn.createStatement();
		//4.ִ��SQL
		String sql = "insert into jdbct1 values(1,'Tom')";
		stat.executeUpdate(sql);
		System.out.println("����ɹ�!");
		//5.�ر���Դ
		stat.close();
		conn.close();
	}
	@Test
	public void testSelect() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		//2.��ȡ���Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		//3.��ȡSQLִ�ж���
		Statement stat = conn.createStatement();
		//4.ִ��SQL
		ResultSet rs = stat.executeQuery("select * from jdbct1");
		//�������
		while(rs.next()){
			int id = rs.getInt("id");
			String name = rs.getString("name");
			System.out.println(id+":"+name);
		}
		//5.�ر���Դ
		stat.close();
		conn.close();
	}
	
}
