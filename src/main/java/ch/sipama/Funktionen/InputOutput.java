package ch.sipama.Funktionen;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import ch.sipama.Daten.ModListe;
import ch.sipama.Daten.Moderator;

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
		// create output streams
		FileOutputStream fos = new FileOutputStream(pfad);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		// write file and close the stream afterwards
		oos.writeObject(serobj);
		oos.close();
	}

	
	public List<Moderator> deserialize() throws IOException, ClassNotFoundException {
		
		// creates the file input and the object input stream
		FileInputStream fis = new FileInputStream(pfad);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// read object from file and save it in serobj
		serobj = (List<Moderator>) ois.readObject();
		
		// close stream and return object
		ois.close();
		return serobj;
	}

}