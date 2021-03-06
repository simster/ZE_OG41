package ch.sipama.Daten;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author simster
 */

public class ModListe implements Serializable{

	//Instanzvariablen
	private static final long serialVersionUID = 1L;
	private static ModListe instance = null;
	private List<Moderator> modListe;
	
	
	private ModListe(){
		
		//ArryListe für die einzelnen Moderatoren erstellen
		modListe = new ArrayList<Moderator>();
		
		//Der Liste zwei Testdatensätze hinzufügen
		modListe.add(new Moderator("Name1", "Forennick1", "Skypenick1", "Server1"));
		modListe.add(new Moderator("Name2", "Forennick2", "Skypenick2", "Server2"));
		modListe.add(new Moderator("Name3", "Forennick3", "Skypenick3", "Server2"));
		modListe.add(new Moderator("Name4", "Forennick4", "Skypenick4", "Server1"));
	}
	
	
	//statische Methode, damit die einzige Instanz dieser Klasse zurückgeliefert wird
	public static ModListe getInstance(){
		if(instance == null){
			instance = new ModListe();
		}
		return instance;
	}

	//Getter und Setter für die Moderatorenliste
	public List<Moderator> getModListe() {
		return modListe;
	}

	public void setModListe(List<Moderator> modListe) {
		this.modListe = modListe;
	}
	
}
