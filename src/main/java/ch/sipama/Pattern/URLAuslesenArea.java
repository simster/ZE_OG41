package ch.sipama.Pattern;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import ch.sipama.Funktionen.Log;

/**
 * @author dreyepat
 */

public class URLAuslesenArea {
	
//	String quelltext;
	
	//Methode zum Auslesen des Quelltextes im Textfeld ausgeben
	public String auslesen() throws Exception {
		
		
		Log.getInstance().getLogger().info("Quelltext im Textfeld ausgeben:");
		URL url = new URL("http://forum.operationgamma41.de/showthread.php?1228-Erfassung-der-Moderationszeiten-!");
		InputStream in = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String quelltext="";
		String s;
		while ((s = reader.readLine()) != null) {
			quelltext = quelltext + s;
			
		}

		return quelltext;
	}
	
}