package ch.sipama.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import ch.sipama.Daten.ModListe;
import ch.sipama.Funktionen.InputOutput;


/**
 * Main Gui Class
 * @author Simone Sterren
 */


public class Hauptgui {
	
	//Instanzvariablen
	private JFrame frame;
	private Container contentPane;
	
	
	//Defaultkonstruktor
	public Hauptgui(){
//		System.out.println("Start");
		
		createFrame();
	}
	
	
	//Fenster erstellen
	public void createFrame(){
		
		//Rahmen erstellen
		frame = new JFrame("Moderationszeiten OG41");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Menübar einbinden, indem die entsprechende Methode aufgerufen wird
		createMenuBar();
		
		//TabbedPane-Layout erstellen
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Moderatoren", new Mod_Gui());
		tabbedPane.addTab("Zeittabellen", new Tabellen_Gui());
		
		//TabbedPane in den Rahmen einfügen
		contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(tabbedPane, BorderLayout.CENTER);
			
		//Rahmengrösse definieren und sichtbar setzen
		frame.setBounds(200, 150, 650, 450);
		frame.setMinimumSize(new Dimension(450, 300));
		frame.setVisible(true);
		
		
	}
	
	
	//Menübar erstellen
	public void createMenuBar(){
		JMenuBar bar = new JMenuBar();
		frame.setJMenuBar(bar);
		
		//Menü 'Datei' mit den Befehle 'Öffnen', 'Speichern' und 'Beenden'
		JMenu dateiMenu = new JMenu("Datei");
		JMenu hilfeMenu = new JMenu("Hilfe");
		bar.add(dateiMenu);
		bar.add(hilfeMenu);
		
		//Menüpunkte erstellen und hinzufügen
		JMenuItem oeffnen = new JMenuItem("Öffnen...");
		dateiMenu.add(oeffnen);
		JMenuItem speichern = new JMenuItem("Speichern...");
		dateiMenu.add(speichern);
		JMenuItem beenden = new JMenuItem("Beenden");
		dateiMenu.add(beenden);
		
		JMenuItem hilfe = new JMenuItem("Anleitung");
		hilfeMenu.add(hilfe);
		JMenuItem ueber = new JMenuItem("Über...");
		hilfeMenu.add(ueber);
		
		//Action-Listener für die Menüpunkte
		//Lädt die in einem File gespeicherten Daten der Moderatoren
		oeffnen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				datenLaden();
			}
		});
		
		//Speichert die Daten der Moderatoren in ein Textfile
		speichern.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				datenSpeichern();
			}
		});
		
		//Schliesst das Programm	
		beenden.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				beenden();
			}
		});
		
		//Öffnet unsere Wiki-Seite
		hilfe.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ladeURL("https://github.com/simster/ZE_OG41/wiki"); 
			}
		});
		
		//Hinweis zur Version
		ueber.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	
	//Fragt den User, ob das Programm wirklich beendet werden soll.
	//Wenn 'Ja' geklickt wird, wird das Programm geschlossen.
	public void beenden(){
		int wertInt = JOptionPane.showConfirmDialog(null, "Wirklich beenden?", "Beenden", 2);
		if (wertInt == 0){
			System.exit(0);
		}
	}
	
	
	//Öffnet den Standardbrowser des Benutzers mit unserer Wiki-Seite und Anleitungen
	private void ladeURL(String seite) { 
        try { 
            Desktop.getDesktop().browse(new URI(seite)); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        } catch (URISyntaxException e) { 
            e.printStackTrace(); 
        } 
    } 
	
	//Laden der gespeicherten Modertoren-Daten
	public void datenLaden(){
		JFileChooser durchsucher = new JFileChooser();
		int choice = durchsucher.showOpenDialog(durchsucher);
		
		if (choice == JFileChooser.APPROVE_OPTION) {  
			File selectedFile = durchsucher.getSelectedFile();
			InputOutput myio = new InputOutput(selectedFile.getAbsolutePath());
			
			try {	
				ModListe.getInstance().setModListe(myio.deserialize());
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			System.out.println("Daten wurden geladen von File: " + selectedFile.getAbsolutePath());
		}
	}
	
	//Speichert die Daten der Moderatoren in ein Textfile
	public void datenSpeichern(){
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setSelectedFile(new File("KontaktData.txt"));
		int choice = jFileChooser.showSaveDialog(frame);
		
		if (choice == JFileChooser.APPROVE_OPTION) {
			 File saveFile = jFileChooser.getSelectedFile();
			 InputOutput myio = new InputOutput(saveFile.getAbsolutePath());
			 
			 try {
				myio.serialize();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Daten wurden abgespeichert in File: " + saveFile.getAbsolutePath());
		 }
	}
}
