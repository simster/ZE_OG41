package ch.sipama.Daten;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author     dreyepat
 */
public class TextUebertragen
{
    private Scanner scanner;

    public TextUebertragen() {
        scanner = new Scanner(System.in);
    }

    public HashSet<String> gibEingabe() 
    {
        String eingabezeile = scanner.nextLine().trim().toLowerCase();

        String[] wortArray = eingabezeile.split(" ");
        
        // W�rter aus dem Array in das Hashset einf�gen
        HashSet<String> woerter = new HashSet<String>();
        for(String wort : wortArray) {
            woerter.add(wort);
        }

        return woerter;
    }
}
