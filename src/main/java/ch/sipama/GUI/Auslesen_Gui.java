package ch.sipama.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import ch.sipama.Funktionen.WebsiteLogin;
import ch.sipama.Pattern.URLAuslesen;
import ch.sipama.Pattern.URLAuslesenArea;
import ch.sipama.Pattern.URLAuslesenFile;

/**
 * Auslesen Gui Class
 * @author Patrizia Dreyer
 */

public class Auslesen_Gui extends JPanel {

	//Instanzvariablen
	private static final long serialVersionUID = 1L;
	private URLAuslesen urlAuslesen;
	private URLAuslesenFile urlAuslesenFile;
	private URLAuslesenArea urlAuslesenArea;

	public Auslesen_Gui() {

		//Layout für diesen Tab setzen
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		urlAuslesen = new URLAuslesen();
		urlAuslesenFile = new URLAuslesenFile();
		urlAuslesenArea = new URLAuslesenArea();
		
		
		//Labels erstellen
		JLabel fileSpeichern = new JLabel("Quelltext in File speichern: ");
		JLabel textKonsole = new JLabel("Quelltext auf Konsole ausgeben: ");
		JLabel textInFeld = new JLabel("Quelltext unten ausgeben: ");
		
		//Buttons und dazugehörige ActionListener erstellen
		JButton inFileSpeichern = new JButton("File erstellen");
		inFileSpeichern.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					auslesenFile();
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});

		JButton auslesenKon = new JButton("Konsole");
		auslesenKon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					auslesen();
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		
		JButton untenAusgeben = new JButton("Textfeld");
		auslesenKon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					auslesenFeld();
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		});
		
		//Textfeld erstellen
		JTextArea textArea = new JTextArea();
		
		textArea.setColumns(50);
        textArea.setLineWrap(true);
        textArea.setRows(10);
//        textArea.setText(urlAuslesenArea.getQuelltext());
        textArea.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(textArea);

		//Buttons und Label dem Gui hinzufügen
		this.add(fileSpeichern);
		this.add(textKonsole);
		this.add(textInFeld);
		this.add(auslesenKon);
		this.add(inFileSpeichern);
		this.add(untenAusgeben);
		this.add(scrollPane);

		//Elemente im Fenster platzieren
		layout.putConstraint(SpringLayout.WEST, fileSpeichern, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, fileSpeichern, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, inFileSpeichern, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, inFileSpeichern, 6, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, textKonsole, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, textKonsole, 20, SpringLayout.SOUTH, fileSpeichern);
		layout.putConstraint(SpringLayout.WEST, auslesenKon, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, auslesenKon, 37, SpringLayout.SOUTH, inFileSpeichern);
		
		layout.putConstraint(SpringLayout.WEST, textInFeld, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, textInFeld, 20, SpringLayout.SOUTH, textKonsole);
		layout.putConstraint(SpringLayout.WEST, untenAusgeben, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, untenAusgeben, 37, SpringLayout.SOUTH, auslesenKon);
		
		layout.putConstraint(SpringLayout.WEST, scrollPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.SOUTH, textInFeld);

	}
	
	public void auslesen() throws Exception {
		
		urlAuslesen.auslesen();
	}
	
	public void auslesenFile() throws Exception {
		
		urlAuslesenFile.auslesen();

	}
	
public void auslesenFeld() throws Exception {
		
		urlAuslesenArea.getQuelltext();
	}
}
