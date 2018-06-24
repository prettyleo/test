package cn.tedu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropDemo {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		//得到文件的输入流
		//class表示类的类型对象
		//getClassLoader()是类的加载器
		//getResourceAsStream获取输入流
		//配置文件都要放在resources这个项目下
		InputStream ips = PropDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//把文件流交给prop
		prop.load(ips);
		//获取保存的数据
		String age = prop.getProperty("age");
		String name = prop.getProperty("name");
		System.out.println(age+":"+name);
	}
}
