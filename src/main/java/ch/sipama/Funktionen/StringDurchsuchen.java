package ch.sipama.Funktionen;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * @author Marco 
 * 12.1.13
 * Methode um URL-String aus URLAuslesenFile.java zu durchsuchen
 */

public class StringDurchsuchen {

	// Pfad muss noch mit Patrizia bestimmt werden
	final static String urlString = ("C:/Users/marcolamm/Documents/GitHub/ZE_OG41/docs/quelltexte/quelltext.txt");

	public void attributeAuslesen() throws FileNotFoundException {
		try {
			BufferedReader bReader = new BufferedReader(new FileReader(
					urlString));

			String sZeile = bReader.readLine();
			while (sZeile != null) {
				sZeile = bReader.readLine();

				if (sZeile.contains("blockfoot actionbuttons")) {
					System.out.println(sZeile);
				} else {
//					System.out.println("Enthält gesuchten String NICHT!");
				}
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

}