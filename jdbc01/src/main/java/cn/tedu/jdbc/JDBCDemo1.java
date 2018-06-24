package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCDemo1 {
	public static void main(String[] args) throws Exception {
		//1. ע������
		Class.forName("com.mysql.jdbc.Driver");
		//2.��ȡ�������Ӷ���
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "123");
		//System.out.println(conn);
		//3.����SQLִ�ж���
		Statement stat = conn.createStatement();
		//4.ִ��SQL 
		//ִ��DDLʹ��execute(),
		//ִ��DMLʹ��executeUpdate()
		//ִ��DQLʹ��executeQuery()
		//String sql = "create table jdbct1(id int, name varchar(10))";
		String sql = "create table if not exists jdbct2(id int, name varchar(10))";
		stat.execute(sql);
		stat.close();
		conn.close();
		
		
		
	}
}
