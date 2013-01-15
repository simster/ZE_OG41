package ch.sipama.Daten;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Marco
 */

public class DienstzeitListe {
	
	//Instanzvariablen
	private static DienstzeitListe instance = null;
	private List<Dienstzeit> dienstzeitListe;
	
	
	public DienstzeitListe(){
		
		//ArryListe für die einzelnen Dienstzeiteinträge erstellen
		setDienstzeitListe(new ArrayList<Dienstzeit>());
		
	}
	
	
	//statische Methode, damit die einzige Instanz dieser Klasse zurückgeliefert wird
		public static DienstzeitListe getInstance(){
			if(instance == null){
				instance = new DienstzeitListe();
			}
			return instance;
		}

		
	//Getter und Setter für die Dienstzeitliste
		public List<Dienstzeit> getDienstzeitListe() {
			return dienstzeitListe;
		}

		public void setDienstzeitListe(List<Dienstzeit> dienstzeitListe) {
			this.dienstzeitListe = dienstzeitListe;
		}
		

}
