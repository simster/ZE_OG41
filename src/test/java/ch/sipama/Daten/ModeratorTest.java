package ch.sipama.Daten;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModeratorTest {
	
	private static Moderator testMod;
	
	//Ein Objekt der Klasse 'Moderator' erstellen
	@BeforeClass
	public static void setUpBeforeClass() {
		testMod = new Moderator ("Tom3775", "Meyer75", "ThorstenTomMeyer", "Silberfuchs");
	}
	
	//Testen, ob die einzelnen Instanzvariablen nach dem erstellen wieder korrekt abgefragt werden können
	@Test
	public void checkConstructorParameters(){
		assertEquals(testMod.getName(), "Tom3775");
		assertEquals(testMod.getForennick(), "Meyer75");
		assertEquals(testMod.getSkypenick(), "ThorstenTomMeyer");
		assertEquals(testMod.getServer(), "Silberfuchs");
		
	}
	
	

}
