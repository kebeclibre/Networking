package launcher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Serv {
	private static boolean finished = false;
	public static void launchServ() {
		
		while (!finished) {
			try {
				ServerSocket serv = new ServerSocket(7100);
				Socket client = serv.accept();
				System.out.println("wow"+client.getInetAddress());
				OutputStream out = client.getOutputStream();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
				bw.write(""+Random110.randomNum());
				bw.flush();
				bw.close();
				
		
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}
			
	
	public static void readDate(String ip) {
		StringBuffer sb = new StringBuffer();
			
			try {
				Socket date = new Socket(ip,8001);
				InputStream in = date.getInputStream();;
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String s = "";
				while ((s = br.readLine()) != null) {
					sb.append(s);
				}
				Thread.yield();
			} catch (IOException e) {
				System.out.println("Unreachable Date " + ip);
			}
			
		
		System.out.println(sb.append(ip+" :").toString());
	}
	
	public static void readInt(String ip) {
		int re = 0;
		Socket num = null;
		try {
			num = new Socket(ip,7100);
		} catch (IOException e1) {
			System.out.println("Unreachable Int " + ip);
		
		StringBuffer sb = new StringBuffer();
			try {
				
				InputStream in = num.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				String s = "";
				while ((s = br.readLine()) != null) {
					sb.append(s);
				}
			} catch (IOException e) {
				System.out.println("Other");
			}
			
		System.out.println(ip+" : "+sb.toString());
	}
	
	}}
