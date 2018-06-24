package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDemo {
	public static void main(String[] args) throws SQLException {
		//1.创建数据源对象
		BasicDataSource dataSource = new BasicDataSource();
		//2.设置数据库连接信息
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db3");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		//3.设置连接池策略信息
		dataSource.setInitialSize(3);//初始连接数量
		dataSource.setMaxActive(5);//最大连数量, 当有第四个连接进来的时候会自动创建第四条连接... ...
		
		//4.从连接池中获取连接对象
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
