package ch.sipama.Daten;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author  simster
 */

public class DienstzeitListTest {
	
	//Test zum Initialisieren der Klasse
	@Test
	public void dienstzeitClassTest(){
		DienstzeitListe.getInstance();
	}
	
	//Methoden der Klasse testen
	@Test
	public void methodenTest(){
		
		//prüfen, ob es wirklich nur 1 Instanze der Dienstzeitliste gibt
		DienstzeitListe dienstzeitListTest1 = DienstzeitListe.getInstance();
		DienstzeitListe dienstzeitListTest2 = DienstzeitListe.getInstance();
		assertEquals(dienstzeitListTest1, dienstzeitListTest2);
		
		
		//Getter und Setter prüfen
		List<Dienstzeit> testList = new ArrayList<Dienstzeit>();
		DienstzeitListe.getInstance().setDienstzeitListe(testList);
		assertEquals(testList, DienstzeitListe.getInstance().getDienstzeitListe());
		
	}
	

}
