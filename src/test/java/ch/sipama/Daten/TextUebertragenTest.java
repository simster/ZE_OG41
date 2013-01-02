package ch.sipama.Daten;


import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
/**
 * @author  dreyepat
 */
public class TextUebertragenTest {
    
	private static TextUebertragen textUebert;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		textUebert = new TextUebertragen();
	}

    public void testGibEingabe() {
    	assertEquals(textUebert.gibEingabe(), "Test Text");
    }
}