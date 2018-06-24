package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {
	Connection conn;
	Statement stat;
	
	public Test1(){
		try {
			//1.注册驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2.建立连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","123");
			//3.获取执行对象
			stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createAction(String tableName){
		String sql = "create table if not exists "+tableName+"(id int primary key auto_increment,name varchar(10));";
		try {
			stat.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertAction(String tableName, int id,String name){
		String sql = "insert into "+tableName+" values(id,"+"'"+name+"')";
		try {
			stat.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void queryAction(String tableName){
		String sql = "select * from "+tableName;
		try {
			ResultSet set = stat.executeQuery(sql);
			while(set.next()){
				int id = set.getInt("id");
				String name = set.getString("name");
				System.out.println(id+":"+name);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void dropAction(String tableName){
		String sql = "drop table "+tableName;
		try {
			stat.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void closeAction(){
		try {
			stat.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Test1 t = new Test1();
		t.createAction("test4");
		t.insertAction("test4", 1, "Leo");
		t.queryAction("test4");
		t.closeAction();
		
	}
}
