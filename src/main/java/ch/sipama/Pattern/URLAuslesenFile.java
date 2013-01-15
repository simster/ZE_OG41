package ch.sipama.Pattern;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.URL;

import ch.sipama.Funktionen.Log;

/**
 * @author dreyepat
 */

public class URLAuslesenFile {
	
	private String zeit;
	private long x;
	
//	long x = 2;
//	String s = (new Long(x)).toString();
	
	public String aktuelleZeit() {
		x = System.currentTimeMillis();
		zeit = (new Long(x)).toString();
		return zeit;
	}
	
	
	// Methode zum Quelltext auslesen und in eine txt-Datei speichern
	public void auslesen() throws Exception {
		
		Log.getInstance().getLogger().info("Quelltext in txt-Datei speichern:");
		URL url = new URL("http://forum.operationgamma41.de/showthread.php?1228-Erfassung-der-Moderationszeiten-!");
		FileOutputStream fos = null;
		fos = new FileOutputStream(".\\docs\\quelltexte\\" + aktuelleZeit()+ ".txt");
		ObjectOutputStream oos = null;
		oos = new ObjectOutputStream(fos);
		InputStream in = url.openStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String s;
		while ((s = reader.readLine()) != null) {
			oos.writeObject(s);
		}

	}

}
