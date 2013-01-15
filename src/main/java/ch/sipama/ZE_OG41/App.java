package ch.sipama.ZE_OG41;

import ch.sipama.Funktionen.Log;
import ch.sipama.GUI.Hauptgui;

/**
 * @author Marco Lamm
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Log.getInstance().getLogger().info("Start der Anwendung");   
        new Hauptgui();
    }
}
