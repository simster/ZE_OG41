package ch.sipama.ZE_OG41;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class URLAuslesen {
	
	public static void main(String[] args) throws Exception {
		 
        URL url = new URL("http://www.fcschlieren.ch/Women");
        InputStream in = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String s;
        while ((s = reader.readLine()) != null) {
        	System.out.println(s);
        }
        
    }
	

}
