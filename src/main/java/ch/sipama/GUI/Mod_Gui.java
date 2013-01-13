package ch.sipama.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import ch.sipama.Daten.ModListe;

public class Mod_Gui extends JPanel {

	//Instanzvariablen
	private static final long serialVersionUID = 1L;
	private JTable modTab;
	private JButton btnLoeschen;

	public Mod_Gui() {

		//Layout für diesen Tab setzen
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);

		//Die Daten der Tabelle
		Vector<Vector<String>> daten = new Vector<Vector<String>>();
		
		for(int i=0; i < ModListe.getInstance().getModListe().size(); i++){
			Vector<String> zeile = new Vector<String>();
			zeile.add(ModListe.getInstance().getModListe().get(i).getServer());
			zeile.add(ModListe.getInstance().getModListe().get(i).getName());
			zeile.add(ModListe.getInstance().getModListe().get(i).getForennick());
			zeile.add(ModListe.getInstance().getModListe().get(i).getSkypenick());	
			daten.add(zeile);	
			
		}
		
		//Die Titel der Tabellenspalten
		Vector<String> spaltentitel = new Vector<String>();
			spaltentitel.add("Server");
			spaltentitel.add("Name");
			spaltentitel.add("Forennick");
			spaltentitel.add("Skypenick");
		
		
		modTab = new JTable(daten, spaltentitel);
		modTab.setPreferredScrollableViewportSize(new Dimension(500,300));
		modTab.setLayout(new FlowLayout());
		modTab.setFillsViewportHeight(true);
		
		JScrollPane scrollPane = new JScrollPane(modTab);
		
		

		//Liste dem GUI hinzufügen
		this.add(scrollPane);
		
		
		//Buttons und dazugehörige ActionListener erstellen
		JButton btnHinzufuegen = new JButton("Hinzufügen");
		btnHinzufuegen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				modErfassen();
			}
		});

		JButton btnBearbeiten = new JButton("Bearbeiten");
		btnBearbeiten.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				modEditieren();
			}
		});
				
		btnLoeschen = new JButton("Löschen");
		btnLoeschen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				modLoeschen();
			}
		});

		//Buttons dem Gui hinzufügen
		this.add(btnBearbeiten);
		this.add(btnHinzufuegen);
		this.add(btnLoeschen);

		//Elemente im Fenster platzieren
		layout.putConstraint(SpringLayout.EAST, btnHinzufuegen, -5, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.SOUTH, btnHinzufuegen, -5, SpringLayout.SOUTH, this);

		layout.putConstraint(SpringLayout.EAST, btnBearbeiten, -5, SpringLayout.WEST, btnHinzufuegen);
		layout.putConstraint(SpringLayout.SOUTH, btnBearbeiten, -5, SpringLayout.SOUTH, this);

		layout.putConstraint(SpringLayout.WEST, btnLoeschen, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.SOUTH, btnLoeschen, -5, SpringLayout.SOUTH, this);

		layout.putConstraint(SpringLayout.WEST, scrollPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, scrollPane, 5, SpringLayout.NORTH, this);

	}

	
	//Neuen Mod der ModListe hinzufügen
	public void modErfassen(){
		
		
		

	}

	//Daten eines existierenden Mods bearbeiten
	public void modEditieren(){
		
	}
		
	//Daten von einem Mod löschen
	public void modLoeschen(){
		int size = modTab.getRowCount();
		
		
		btnLoeschen.setEnabled(size > 1);
		
	}
	
	//Liste mit den Moderatoren im GUI aktualisieren
	public void refreshListe(){
		// TODO Liste der Mods nach der Bearbeitung korrekt aktualisieren		
	}
	
	

}
