package ch.sipama.Pattern;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import ch.sipama.Funktionen.Log;

/**
 * @author dreyepat
 */

public class URLAuslesen {
	
	//Methode zum Auslesen des Quelltextes und auf der Konsole ausgeben
	public void auslesen() throws Exception {
		
		Log.getInstance().getLogger().info("Quelltext auf Konsole ausgeben:");
		URL url = new URL("http://forum.operationgamma41.de/showthread.php?1228-Erfassung-der-Moderationszeiten-!");
		InputStream in = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String s;
		while ((s = reader.readLine()) != null) {
			System.out.println(s);

		}
	}
}

