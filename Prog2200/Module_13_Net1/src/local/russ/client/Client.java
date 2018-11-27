package local.russ.client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Client {
	  private static Socket clnt;

	public static void main(String[] args) {
	    System.out.print(RunSocketClient());
	  }

	  public static String RunSocketClient() {
	    try {
	        clnt = new Socket("172.16.176.101",4444);
	        BufferedReader in = new BufferedReader(new InputStreamReader(clnt.getInputStream()));

	        String fromServer;
	        fromServer = in.readLine();

	        return fromServer;
	    } catch (IOException e) {
	        return "nothing";
	    }
	  }
	}