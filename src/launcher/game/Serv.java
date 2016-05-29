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
import model.ThreadClientGame;

public class Serv {
	private static boolean finished = false;
	private static ServerSocket serv;
	
	public static void main(String[] args) {
		while (!finished) {
			try {
				serv = new ServerSocket(7000);
				Socket client = serv.accept();
				System.out.println("wow"+client.getInetAddress());
				new Thread(new ThreadClientGame(client)).start();
				
				
					
				
				serv.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


