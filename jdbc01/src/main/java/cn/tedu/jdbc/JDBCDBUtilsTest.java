package cn.tedu.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.SynchronousQueue;

import org.junit.Test;

public class JDBCDBUtilsTest {
	@Test
	public void insert(){
		//�Ѹ�����Դ������try catch������Ϊ��ʹ������finally��ɼ�
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//ȡ�����Ӷ���
			conn = DBUtils.getConn();
			//ȡ��SQLִ�ж���
			stat = conn.createStatement();
			//ִ��SQL
			String sql = "insert into jdbct1 values(4,'����')";
			stat.executeUpdate(sql);
			System.out.println("����ɹ�!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBUtils.close(rs, stat, conn);
		}
	}


	@Test
	public void select(){
		//�Ѹ�����Դ������try catch������Ϊ��ʹ������finally��ɼ�
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//ȡ�����Ӷ���
			conn = DBUtils.getConn();
			//ȡ��SQLִ�ж���
			stat = conn.createStatement();
			//ִ��SQL
			rs = stat.executeQuery("select * from jdbct1");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id+":"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBUtils.close(rs, stat, conn);
		}
	}



	@Test
	public void update(){
		//�Ѹ�����Դ������try catch������Ϊ��ʹ������finally��ɼ�
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//ȡ�����Ӷ���
			conn = DBUtils.getConn();
			//ȡ��SQLִ�ж���
			stat = conn.createStatement();
			//ִ��SQL
			String sql = "update jdbct1 set name='������' where id=3";
			stat.executeUpdate(sql);
			System.out.println("�޸ĳɹ�");

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBUtils.close(rs, stat, conn);
		}
	}


	@Test
	public void delete(){
		//�Ѹ�����Դ������try catch������Ϊ��ʹ������finally��ɼ�
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//ȡ�����Ӷ���
			conn = DBUtils.getConn();
			//ȡ��SQLִ�ж���
			stat = conn.createStatement();
			//ִ��SQL
			String sql = "delete from jdbct1 where name='������'";
			stat.executeUpdate(sql);
			System.out.println("ɾ���ɹ�!");

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//�ر���Դ
			DBUtils.close(rs, stat, conn);
		}
	}

}

