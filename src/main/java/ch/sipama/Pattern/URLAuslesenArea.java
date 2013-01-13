package ch.sipama.Pattern;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import ch.sipama.Funktionen.Log;

public class URLAuslesenArea {
	
	String quelltext;
	
	//Methode zum Auslesen des Quelltextes im Textfeld ausgeben
	public void auslesen() throws Exception {
		
//		String quelltext;
		Log.getInstance().getLogger().info("Quelltext im Textfeld ausgeben:");
		URL url = new URL("http://forum.operationgamma41.de/showthread.php?1228-Erfassung-der-Moderationszeiten-!");
		InputStream in = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while ((quelltext = reader.readLine()) != null) {
			System.out.println(quelltext);

		}
	}
	
	public String getQuelltext() {
		
		Log.getInstance().getLogger().info("Quelltext im Textfeld mit getQuelltext() ausgeben:");
		return quelltext;
	}
}