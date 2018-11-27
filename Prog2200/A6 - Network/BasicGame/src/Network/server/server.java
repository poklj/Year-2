package Network.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class server {

	public static void main(String[] args) {
		String ip = getIpAddress();

		try {
			ServerSocket srvr = new ServerSocket(4444);
			
			Socket client = null;
			try {
				
				
			} catch (Exception e) {
				System.out.print(String.format("Accept failed: %s", e));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public static String getIpAddress() {
		InetAddress host;
		String ipString = "false";

		try {
			host = InetAddress.getLocalHost();
			ipString = host.getHostAddress();
		} catch (UnknownHostException e) {
			System.out.println(e);
		}

		return ipString;
	}
}
