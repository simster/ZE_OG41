package ch.sipama.ZE_OG41;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public abstract class URLAuslesen {

	public void auslesen() throws Exception {
		
		System.out.println("URLAuslesen");
		URL url = new URL("http://forum.operationgamma41.de/showthread.php?1228-Erfassung-der-Moderationszeiten-!");
		InputStream in = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String s;
		while ((s = reader.readLine()) != null) {
			System.out.println(s);

		}
	}
}

