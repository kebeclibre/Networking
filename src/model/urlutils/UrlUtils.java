package model.urlutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtils {
	private static UrlUtils instance;
	
	public static UrlUtils getInstance() {
		if (instance == null) {
			return instance = new UrlUtils();
		} else {
			return instance;
		}
	}
	
	public String dispResource(String url) {
		URL urlObj = null;
		StringBuffer sb = new StringBuffer();
		try {
			 urlObj = new URL(url);
			 InputStream in = urlObj.openStream();
			 BufferedReader br = new BufferedReader(new InputStreamReader(in));
			 String line= "";
			 while ((line = br.readLine()) != null) {
				 sb.append(line).append("\n");
			 }
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
	
}
