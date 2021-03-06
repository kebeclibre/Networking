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
				ServerSocket serv = new ServerSocket(7000);
				Socket client = serv.accept();
				System.out.println("wow"+client.getInetAddress());
				OutputStream out = client.getOutputStream();
				PrintWriter pw = new PrintWriter(out,true);
				pw.write(""+Random110.randomNum());
				pw.close();
				serv.close();
		
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
		try {
			Socket num = new Socket(ip,7000);
			StringBuffer sb = new StringBuffer();
			InputStream in = num.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String s = "";
			while ((s = br.readLine()) != null) {
				sb.append(s);
			}
			num.close();
			System.out.println(ip+" : "+sb.toString());
		} catch (IOException e1) {
			System.out.println("Unreachable Int " + ip);
			
		
	}
	
	}}
