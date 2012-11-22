package ch.sipama.GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


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
		System.out.println("Start");
		createFrame();
	}
	
	
	//Fenster erstellen
	public void createFrame(){
		
		//Rahmen erstellen
		frame = new JFrame("Moderationszeiten OG41");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Menübar einbinden, indem die entsprechende Methode aufgerufen wird
		createMenuBar();
		
		
		// add tabbed menu now to the container of the frame
		contentPane = frame.getContentPane();
		contentPane.setLayout(new BorderLayout());
			
		
		
		
		
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
		bar.add(dateiMenu);
		
		//Menüpunkte erstellen und hinzufügen
		JMenuItem oeffnen = new JMenuItem("Öffnen...");
		dateiMenu.add(oeffnen);
		JMenuItem speichern = new JMenuItem("Speichern...");
		dateiMenu.add(speichern);
		JMenuItem beenden = new JMenuItem("Beenden");
		dateiMenu.add(beenden);
		
		//Action-Listener für die Menüpunkte
		oeffnen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		speichern.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		
		beenden.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				beenden();
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
	
	
	

}
