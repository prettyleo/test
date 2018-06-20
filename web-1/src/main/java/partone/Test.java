package partone;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test {
	public static void main(String[] args) {
		try {
			InetAddress hostName=InetAddress.getLocalHost();
			String ip = hostName.getHostAddress();
			System.out.println(ip);
			String str = hostName.getHostName();
			System.out.println(str);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		
	}
}
