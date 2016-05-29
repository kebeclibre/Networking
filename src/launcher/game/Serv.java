package launcher.game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import launcher.Random110;
import model.Proto;

public class Serv {
	private static boolean finished = false;
	
	public static void main(String[] args) {
		while (!finished) {
			try {
				ServerSocket serv = new ServerSocket(7000);
				Socket client = serv.accept();
				System.out.println("wow"+client.getInetAddress());
				
				InputStream inClient = client.getInputStream();
				OutputStream outClient = client.getOutputStream();
				
				boolean success = false;
				
				
				
				int toGuess = Random110.randomNum();
				PrintWriter pw = new PrintWriter(outClient,true);
				BufferedReader br = new BufferedReader(new InputStreamReader(inClient));
				Proto proto = new Proto(br,pw);
				proto.write("Welcome\n");
				while (!success) {
					
					proto.write("Enter a Number :\n");
					System.out.println("To Guess : "+toGuess);
					int resp =Integer.parseInt(proto.read());
					System.out.println(resp);
					if (resp == toGuess) {
						proto.write("success: "+toGuess+"\n" );
						proto.write("STOP");
						success = true;
						client.close();
					} else if (resp > toGuess) {
						//pw = new PrintWriter(outClient,true);
						proto.write("too High\n");
						System.out.println("Answered : "+resp);
					} else {
						//pw= new PrintWriter(outClient,true);
						proto.write("too Low\n");
						System.out.println("Answered : "+resp);
					}
					
				}
				serv.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}


