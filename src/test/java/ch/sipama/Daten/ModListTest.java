package ch.sipama.Daten;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ModListTest {

	@Test
	public void modListClassTest(){
		ModListe.getInstance();
	}


	@Test
	public void methodenTest(){

		//prüfen, ob es wirklich nur 1 Instanz der Modliste gibt
		ModListe modListTest1 = ModListe.getInstance();
		ModListe modListTest2 = ModListe.getInstance();
		assertEquals(modListTest1, modListTest2);


		//Getter und Setter prüfen
		List<Moderator> testList = new ArrayList<Moderator>();
		ModListe.getInstance().setModListe(testList);
		assertEquals(testList, ModListe.getInstance().getModListe());


	}





}
