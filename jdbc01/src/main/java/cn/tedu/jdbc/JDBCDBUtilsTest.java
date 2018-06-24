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
		//把各种资源声明在try catch外面是为了使变量在finally里可见
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//取得连接对象
			conn = DBUtils.getConn();
			//取得SQL执行对象
			stat = conn.createStatement();
			//执行SQL
			String sql = "insert into jdbct1 values(4,'刘备')";
			stat.executeUpdate(sql);
			System.out.println("插入成功!");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}


	@Test
	public void select(){
		//把各种资源声明在try catch外面是为了使变量在finally里可见
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//取得连接对象
			conn = DBUtils.getConn();
			//取得SQL执行对象
			stat = conn.createStatement();
			//执行SQL
			rs = stat.executeQuery("select * from jdbct1");
			while(rs.next()){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id+":"+name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}



	@Test
	public void update(){
		//把各种资源声明在try catch外面是为了使变量在finally里可见
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//取得连接对象
			conn = DBUtils.getConn();
			//取得SQL执行对象
			stat = conn.createStatement();
			//执行SQL
			String sql = "update jdbct1 set name='李连杰' where id=3";
			stat.executeUpdate(sql);
			System.out.println("修改成功");

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}


	@Test
	public void delete(){
		//把各种资源声明在try catch外面是为了使变量在finally里可见
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		try {
			//取得连接对象
			conn = DBUtils.getConn();
			//取得SQL执行对象
			stat = conn.createStatement();
			//执行SQL
			String sql = "delete from jdbct1 where name='李连杰'";
			stat.executeUpdate(sql);
			System.out.println("删除成功!");

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			//关闭资源
			DBUtils.close(rs, stat, conn);
		}
	}

}

