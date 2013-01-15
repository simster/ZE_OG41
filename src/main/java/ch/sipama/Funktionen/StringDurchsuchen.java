package ch.sipama.Funktionen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/*
 * @author Marco 
 * 15.1.13
 * Methode um URL-String aus URLAuslesenFile.java zu durchsuchen
 */

public class StringDurchsuchen {

	// Pfad muss noch mit Patrizia bestimmt werden

	// while ( ( strLine = br.readLine() ) != null)
	// System.out.println(strLine);
	// br.close();

	// final static String urlString =
	// ("C:/Users/marcolamm/Documents/GitHub/ZE_OG41/docs/quelltexte/quelltext.txt");
	// final static String urlString =
	// ("https://github.com/simster/ZE_OG41/blob/master/docs/quelltexte/quelltext.txt");

	public void attributeAuslesen() {
		URL llll = null;

		try {
			llll = new URL(
					"http://github.com/simster/ZE_OG41/blob/master/docs/quelltexte/quelltext.txt");
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		URLConnection conLLL = null;
		try {
			conLLL = llll.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conLLL.getInputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String urlString = "";

		try {
			BufferedReader bReader = new BufferedReader(new FileReader(
					urlString));

			String sZeile = bReader.readLine();
			while (sZeile != null) {
				sZeile = bReader.readLine();

				if (sZeile.contains("blockfoot actionbuttons")) {
					System.out.println(sZeile);
				} else {
					System.out.println("Enthält gesuchten String NICHT!");
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}