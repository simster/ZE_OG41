package ch.sipama.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ch.sipama.ZE_OG41.URLAuslesen;
import ch.sipama.ZE_OG41.URLAuslesenFile;

/**
 * Auslesen Gui Class
 * @author Patrizia Dreyer
 */

public class Auslesen_Gui extends JPanel {

	//Instanzvariablen
	private static final long serialVersionUID = 1L;
	private URLAuslesen urlAuslesen;
	private URLAuslesenFile urlAuslesenFile;

	public Auslesen_Gui() {

		//Layout für diesen Tab setzen
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		
		//Label erstellen
		JLabel fileSpeichern = new JLabel("Quelltext in File speichern: ");
		JLabel textKonsole = new JLabel("Quelltext auf Konsole ausgeben: ");
		
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
				

		//Buttons und Label dem Gui hinzufügen
		this.add(fileSpeichern);
		this.add(textKonsole);
		this.add(auslesenKon);
		this.add(inFileSpeichern);

		//Elemente im Fenster platzieren
		layout.putConstraint(SpringLayout.WEST, fileSpeichern, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, fileSpeichern, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, inFileSpeichern, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, inFileSpeichern, 6, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, textKonsole, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, textKonsole, 20, SpringLayout.SOUTH, fileSpeichern);
		layout.putConstraint(SpringLayout.WEST, auslesenKon, 200, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, auslesenKon, 37, SpringLayout.SOUTH, inFileSpeichern);

	}
	
	public void auslesen() throws Exception {
		urlAuslesen.auslesen();
	}
	
	public void auslesenFile() throws Exception {
		urlAuslesenFile.auslesen();
	}
}
