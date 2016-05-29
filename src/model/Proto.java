package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Proto {
	private BufferedReader br;
	private PrintWriter pw;
	
	
	public Proto (BufferedReader br, PrintWriter pw) {
		this.br = br;
		this.pw = pw;
	}
	
	public void write(String mess) {
		char[] ba = mess.toCharArray();
		
		pw.write(ba.length);
		pw.write(ba);
		pw.flush();
		
	}
	
	public String read() {
		StringBuffer sb = new StringBuffer();
		try {
			int len = br.read();
			for (int i=0; i <len;i++) {
				//Character.toChars(br.read());
				sb.append(Character.toChars(br.read()));
			}
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return sb.toString();
	}
}
