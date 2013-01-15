package ch.sipama.Daten;


import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author  dreyepat
 */
public class TextUebertragenTest {
    
	//Instanzvariable
	private static TextUebertragen textUebert;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		textUebert = new TextUebertragen();
	}

	@Test
    public void testGibEingabe() {
    	assertEquals(textUebert.gibEingabe(), "test, text");
    }
}