package parttwo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HttpRequest {
	private Socket socket;
	private InputStream in;
	
	//请求行
	private String method;
	private String url;
	private String protocal;
	
	//消息头
	private Map<String,String> headers=new HashMap<String,String>();
	
	//消息文本
	private String content;

	public HttpRequest(Socket socket) {
		try {
			this.socket = socket;
			this.in=socket.getInputStream();
			parseRequestLine();
			parseHeaders();
			parseContent();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//解析请求行方法
	private void parseRequestLine(){
		System.out.println("解析请求行的方法");
		String line=readLine();
		String[] data = line.split("\\s");
		method=data[0];
		url=data[1];
		protocal=data[2];
	}
	
	//解析消息头的方法
	private void parseHeaders(){
		while(true){
			System.out.println("解析消息头的方法");
			String line=readLine();
			if("".equals(line)){
				break;
			}
			String[] data = line.split(":\\s");
			headers.put(data[0], data[1]);
		}
	}
	
	//解析消息体的方法
	private void parseContent(){
		System.out.println("解析消息体的方法");
	}
	
	//读行的方法
	private String readLine(){
		try {
			StringBuilder sb=new StringBuilder();
			char c1='a', c2='a';
			int len=-1;
			while((len=in.read())!=-1){
				c2=(char)len;
				if(c1==13 && c2==10){
					break;
				}
				sb.append(c2);
				c1=c2;
			}
			return sb.toString().trim();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getProtocal() {
		return protocal;
	}

	public String getHeaders(String key) {
		return headers.get(key);
	}
	
	
	
}
