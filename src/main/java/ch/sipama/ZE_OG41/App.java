package ch.sipama.ZE_OG41;

import ch.sipama.Funktionen.Log;
import ch.sipama.GUI.Hauptgui;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Log.getInstance().getLogger().info("Start der Anwendung");
        System.out.println( "Hello World!" );
        System.out.println("Ich gebe auch meinen Senf dazu...");
        System.out.println("Ich teste auch noch.");
        
        new Hauptgui();
        new StrategyAusfuehren();
    }
}
