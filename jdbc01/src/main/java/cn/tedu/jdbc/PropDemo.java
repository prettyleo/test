package cn.tedu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropDemo {
	public static void main(String[] args) throws IOException {
		Properties prop = new Properties();
		//�õ��ļ���������
		//class��ʾ������Ͷ���
		//getClassLoader()����ļ�����
		//getResourceAsStream��ȡ������
		//�����ļ���Ҫ����resources�����Ŀ��
		InputStream ips = PropDemo.class.getClassLoader().getResourceAsStream("jdbc.properties");
		//���ļ�������prop
		prop.load(ips);
		//��ȡ���������
		String age = prop.getProperty("age");
		String name = prop.getProperty("name");
		System.out.println(age+":"+name);
	}
}
