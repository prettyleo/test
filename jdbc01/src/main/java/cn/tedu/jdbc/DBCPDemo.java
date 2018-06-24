package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

public class DBCPDemo {
	public static void main(String[] args) throws SQLException {
		//1.��������Դ����
		BasicDataSource dataSource = new BasicDataSource();
		//2.�������ݿ�������Ϣ
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/db3");
		dataSource.setUsername("root");
		dataSource.setPassword("123");
		//3.�������ӳز�����Ϣ
		dataSource.setInitialSize(3);//��ʼ��������
		dataSource.setMaxActive(5);//���������, ���е��ĸ����ӽ�����ʱ����Զ���������������... ...
		
		//4.�����ӳ��л�ȡ���Ӷ���
		Connection conn = dataSource.getConnection();
		System.out.println(conn);
	}
}
