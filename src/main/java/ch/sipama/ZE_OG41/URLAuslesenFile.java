package ch.sipama.ZE_OG41;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.URL;

public abstract class URLAuslesenFile {

	public void auslesen() throws Exception {
		
		System.out.println("URLAuslesenFile");
		URL url = new URL("http://forum.operationgamma41.de/showthread.php?1228-Erfassung-der-Moderationszeiten-!");
		FileOutputStream fos = null;
		fos = new FileOutputStream("quelltext.txt");
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
