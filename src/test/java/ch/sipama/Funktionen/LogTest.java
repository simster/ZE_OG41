package ch.sipama.Funktionen;

import static org.junit.Assert.*;
import org.junit.Test;
import org.slf4j.Logger;

/**
 * @author  simster
 */

public class LogTest {


	//Initialisieren der Klasse testen
	@Test
	public void logTestClass(){
		Log.getInstance();
	}


	//Methoden testen und prüfen, ob wirklich nur 1 Instanz der Klasse erstellt wird
	@Test
	public void methodenTest(){

		Log logger1 = Log.getInstance();
		Log logger2 = Log.getInstance();
		assertEquals(logger1, logger2);


		Logger logger = Log.getInstance().getLogger();
		assertEquals(logger, Log.getInstance().getLogger());

	}


}
