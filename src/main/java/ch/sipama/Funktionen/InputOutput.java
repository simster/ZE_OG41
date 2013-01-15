package ch.sipama.Funktionen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import ch.sipama.Daten.ModListe;
import ch.sipama.Daten.Moderator;

/**
 * @author simster
 */

public class InputOutput {

	//Instanzvariablen
	private List<Moderator> serobj;
	private String pfad;

	
	//Konstruktor für die Datenspeicherung
	public InputOutput(String pfad) {
		this.serobj = ModListe.getInstance().getModListe();
		this.pfad = pfad;
	}

	//Objekt serialisieren
	public void serialize() throws IOException {
		FileOutputStream fos = new FileOutputStream(pfad);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(serobj);
		oos.close();
	}

	
	public List<Moderator> deserialize() throws IOException, ClassNotFoundException {
		
		//File- und Objekt-Inputstream erstellen
		FileInputStream fis = new FileInputStream(pfad);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//serialisiertes Objekt erstellen
		serobj = (List<Moderator>) ois.readObject();
		
		//Stream schliessen und Objekt zurückgeben
		ois.close();
		return serobj;
	}

}