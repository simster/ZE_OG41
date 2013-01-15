package ch.sipama.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Simone Sterren
 */


public class Ueber_GUI {

	// Instanzvariablen
	private JPanel contentPane;
	private JFrame frame;

	// Neues Dialogfenster öffnen
	public Ueber_GUI(){
		frame = new JFrame();
		showAbout();
	}


	public void showAbout() {

		// Dialogfenster erstellen
		frame.setBounds(250, 200, 180, 180);
		frame.setResizable(false);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		frame.setContentPane(contentPane);

		// Titel setzen und Schrift
		JLabel lblProjekt = new JLabel("Projektarbeit ZE_OG41");
		lblProjekt.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblProjekt, BorderLayout.NORTH);

		// Inhalt dem Panel hinzufügen
		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));
		
		JLabel lblAbstand1 = new JLabel("********************");
		lblAbstand1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAbstand1);

		// Projektmitlgieder aufführen
		JLabel lblPatriziaDreyer = new JLabel("Patrizia Dreyer");
		lblPatriziaDreyer.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblPatriziaDreyer);

		JLabel lblSimoneSterren = new JLabel("Simone Sterren");
		lblSimoneSterren.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblSimoneSterren);

		JLabel lblDominicSchlegel = new JLabel("Marco Lamm");
		lblDominicSchlegel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblDominicSchlegel);

		
		// Versionsnummer
		JLabel lblAbstand2 = new JLabel("********************");
		lblAbstand2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAbstand2);
		JLabel lblVersionsnummer = new JLabel("Version 2013.1.0");
		lblVersionsnummer.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblVersionsnummer);

		// Fenster auf sichtbar stellen
		frame.setVisible(true);
	}

}
