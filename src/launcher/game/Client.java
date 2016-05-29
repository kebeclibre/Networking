package launcher.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import model.Proto;

public class Client {
	private static Socket sok;
	private static boolean success = false;
	
	public static void main(String[] args) {
		try {
			StringBuffer sb = new StringBuffer();
			sok = new Socket("127.0.0.1",7000);
			PrintWriter pw = new PrintWriter(sok.getOutputStream(),true);
			BufferedReader br = new BufferedReader( new InputStreamReader(sok.getInputStream()));
			Proto proto = new Proto(br,pw);
			
			while (!success) {
				//System.out.println("while");
				String st = proto.read();
				System.out.print(st);
				if (st.equals("Enter a Number :\n")) {
					Scanner scan = new Scanner(System.in);
					String resp = scan.nextLine();
					proto.write(resp);
			
					//System.out.println(resp);
				}else if (st.equals("STOP")) {
					success = true;
					sok.close();
				}
			
			
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	
	
	}
}
