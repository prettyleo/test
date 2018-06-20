package partone;

import java.net.Socket;

import parttwo.HttpRequest;

public class ClientHandler implements Runnable{
	private Socket socket;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		System.out.println("启动一个线程处理与客户端交互");
		HttpRequest hr=new HttpRequest(socket);
	}
	
	
}
