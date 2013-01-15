package ch.sipama.Funktionen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/*
 * @author Marco
 * 15.1.13
 * Methode um URL-String aus URLAuslesenFile.java zu durchsuchen
 */

public class StringDurchsuchen {

	//Instanzvariable
	private BufferedReader bReader;

	public void attributeAuslesen() {

		try {
			URL llll = new URL(
					"https://github.com/simster/ZE_OG41/blob/master/docs/quelltexte/quelltext.txt");

			URLConnection conLLL = llll.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					conLLL.getInputStream()));
			String urlString = "";
			// br.close();

			bReader = new BufferedReader(new FileReader(
					urlString));

			String sZeile = bReader.readLine();
			while (sZeile != null) {
				sZeile = bReader.readLine();

				if (sZeile.contains("blockfoot actionbuttons")) {
					Log.getInstance().getLogger().info(sZeile);
				} else {
					Log.getInstance().getLogger().info("Enthält gesuchten String NICHT!");
				}
			}
			br.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}
}