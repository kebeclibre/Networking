package launcher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

import model.urlutils.UrlUtils;

public class mainUrl {
	String ips ="192.168.22.";
	public static void tryOut() {
		int limit = 1;
		int i=0;
		while (i<limit) {
		StringBuffer sb = new StringBuffer();
		try {
			Socket sok = new Socket("192.168.22.100", 8000);
			InputStream in = sok.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
		} catch (IOException e) {
		}
		System.out.println(sb.toString());
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Serv.readInt("127.0.0.1");
		
	}
		
		
		/*Thread tDate = new Thread( new Runnable() {
			public void run() {
				String ips ="192.168.22.";
				//for (int i = 1; i<200;i++) {
				Serv.readDate(ips+109);
				//}
			}
		});
		
		Thread tNum = new Thread( new Runnable() {
			public void run() {
				String ips ="192.168.22.";
				//for (int i = 1; i<200;i++) {
				Serv.readInt(ips+109);}
			//}
		});
		

		//tDate.start();
		tNum.start();
	}*/

	
}
