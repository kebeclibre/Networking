package model;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class CusUrl {
	private String url;
	public CusUrl(String url) {
		this.url = url;
	}

	public File getFile() {
		try {
			URL obj = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
