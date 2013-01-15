package ch.sipama.Funktionen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author simster
 */


public class Log {
	
	//Instanzvariablen
	private static Log instance = null;
	private static final Logger logger = LoggerFactory.getLogger(Log.class);

	//Sicherstellen, dass nur eine Instanz des Loggers existiert
	public static Log getInstance(){
		if(instance == null){
			instance = new Log();
		}
		return instance;
	}

	
	//Getter für den Logger
	public Logger getLogger() {
		return logger;
	}

	
	
	

}
