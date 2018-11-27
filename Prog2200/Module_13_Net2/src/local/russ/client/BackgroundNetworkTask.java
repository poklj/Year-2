package local.russ.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class BackgroundNetworkTask extends Thread {

	public void run() {
		System.out.print(RunSocketClient());
	}

	private static Socket clnt;

	public static String RunSocketClient() {
		try {
			clnt = new Socket("192.168.0.2", 4444);
			BufferedReader in = new BufferedReader(new InputStreamReader(
					clnt.getInputStream()));

			String fromServer;
			fromServer = in.readLine();

			return fromServer;
		} catch (IOException e) {
			return "nothing";
		}
	}

}
