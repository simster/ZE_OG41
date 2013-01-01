package ch.sipama.Funktionen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class Log {
	
	//Instanzvariablen
	private static Log instance = null;
	private static final Logger logger = LoggerFactory.getLogger(Log.class);

	public static Log getInstance(){
		if(instance == null){
			instance = new Log();
		}
		return instance;
	}

	public Logger getLogger() {
		return logger;
	}

	
	
	

}
