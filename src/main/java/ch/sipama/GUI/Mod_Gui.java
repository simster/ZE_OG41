package ch.sipama.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ch.sipama.Daten.ModListe;

public class Mod_Gui extends JPanel {

	//Instanzvariablen
	private DefaultListModel<String> listModel;
	final JList<String> listMods;
	private static final long serialVersionUID = 1L;

	public Mod_Gui() {

		//Layout für diesen Tab setzen
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);

		//Default List Model Objekt erstellen
		listModel = new DefaultListModel<String>();

		//Jeden Moderator aus der ArrayListe dem ListModel hinzufügen
		for(int i=0; i< ModListe.getInstance().getModListe().size(); i++){
			String bezeichnung = ModListe.getInstance().getModListe().get(i).getServer() + " " + ModListe.getInstance().getModListe().get(i).getName();
			listModel.add(i, bezeichnung);
		}

		//Liste fürs Gui erstellen
		listMods = new JList<String>(listModel);
		listMods.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMods.setSelectedIndex(0);
		listMods.setVisibleRowCount(8);
		JScrollPane listScrollPane = new JScrollPane(listMods);

		//Liste dem GUI hinzufügen
		this.add(listScrollPane);

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
				
		JButton btnLoeschen = new JButton("Löschen");
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

		layout.putConstraint(SpringLayout.WEST, listScrollPane, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, listScrollPane, 5, SpringLayout.NORTH, this);

	}

	
	//Neuen Mod der ModListe hinzufügen
	public void modErfassen(){

	}

	//Daten eines existierenden Mods bearbeiten
	public void modEditieren(){
		
	}
		
	//Daten von einem Mod löschen
	public void modLoeschen(){
		if(JOptionPane.showConfirmDialog(this, "Möchten Sie die Daten dieses Moderators wirklich endgültig löschen?", "Warnhinweis", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
			ModListe.getInstance().getModListe().remove(listMods.getSelectedIndex());
		}
		refreshListe();
	}
	
	//Liste mit den Moderatoren im GUI aktualisieren
	public void refreshListe(){
		// TODO Liste der Mods nach der Bearbeitung korrekt aktualisieren		
	}
	
	

}
