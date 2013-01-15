package ch.sipama.Daten;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * @author  simster
 */

public class ModeratorTest {
	
	//Instanzvariable
	private Moderator testMod;
	
	
	//Das Erstellen einer Moderator-Klasse testen
	@Test
	public void modClassTest(){
		testMod = new Moderator("Name", "Forennick", "Skypenick", "Server");
	}
	
	
	
	//Testen, ob die einzelnen Instanzvariablen nach dem erstellen wieder korrekt abgefragt werden können
	@Test
	public void checkConstructorParameters(){
			
		testMod = new Moderator ("Tom3775", "Meyer75", "ThorstenTomMeyer", "Silberfuchs");
		
		assertEquals(testMod.getName(), "Tom3775");
		assertEquals(testMod.getForennick(), "Meyer75");
		assertEquals(testMod.getSkypenick(), "ThorstenTomMeyer");
		assertEquals(testMod.getServer(), "Silberfuchs");
	}
	
	//Setter-Methoden testen
	@Test
	public void methodenTest(){
		
		testMod = new Moderator ("Tom3775", "Meyer75", "ThorstenTomMeyer", "Silberfuchs");
		
		//Setter-Methoden testen
		testMod.setForennick("Jerry77");
		assertEquals("Jerry77", testMod.getForennick());
		
		testMod.setName("Scherrer");
		assertEquals("Scherrer", testMod.getName());
		
		testMod.setServer("Ikarus");
		assertEquals("Ikarus", testMod.getServer());
		
		testMod.setSkypenick("Jerry Scherrer 77");
		assertEquals("Jerry Scherrer 77", testMod.getSkypenick());
	}

}
