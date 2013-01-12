package ch.sipama.Daten;

import static org.junit.Assert.*;

import org.junit.Test;



public class DienstzeitTest {
	
	private Dienstzeit testDienstzeit;
	
	
	@Test
	public void dienstzeitClassTest(){
		testDienstzeit = new Dienstzeit(1234, 3456, ModListe.getInstance().getModListe().get(0));
	}
	
	
	//Testen, ob die Instanzvariablen korrekt abgefragt werden können
	@Test
	public void checkConstructorParameters(){
		
		testDienstzeit = new Dienstzeit(1234, 3456, ModListe.getInstance().getModListe().get(0));
		
		assertEquals(testDienstzeit.getStartzeit(), 1234);
		assertEquals(testDienstzeit.getEndzeit(), 3456);
		assertEquals(testDienstzeit.getMod(),  ModListe.getInstance().getModListe().get(0));
		assertEquals(testDienstzeit.getDauer(), 3456-1234);
		
	}
	
	@Test
	public void methodenTest(){
		
		testDienstzeit = new Dienstzeit(1234, 3456, ModListe.getInstance().getModListe().get(0));
		
		//Setter-Methoden testen
		testDienstzeit.setStartzeit(4567);
		assertEquals(testDienstzeit.getStartzeit(), 4567);
		
		testDienstzeit.setEndzeit(9999);
		testDienstzeit.setDauer(testDienstzeit.getEndzeit()-testDienstzeit.getStartzeit());
		assertEquals(testDienstzeit.getEndzeit(), 9999);
		assertEquals(testDienstzeit.getDauer(), 9999-4567);
		
		testDienstzeit.setMod(ModListe.getInstance().getModListe().get(1));
		assertEquals(testDienstzeit.getMod(), ModListe.getInstance().getModListe().get(1));
		
	}
	
}
