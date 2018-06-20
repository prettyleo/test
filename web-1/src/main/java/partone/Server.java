package partone;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket ss;
	
	public Server() {
		try {
			ss=new ServerSocket(8080);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start(){
		try {
			System.out.println("等待客户端连接...");
			Socket socket=ss.accept();
			System.out.println("一个客户端连接了!");
			ClientHandler ch=new ClientHandler(socket);
			Thread t=new Thread(ch);
			t.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}
}
