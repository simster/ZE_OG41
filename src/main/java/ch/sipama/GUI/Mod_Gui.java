package ch.sipama.GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ch.sipama.Daten.ModListe;
import ch.sipama.Funktionen.Log;

public class Mod_Gui extends JPanel {

	//Instanzvariablen
	private static final long serialVersionUID = 1L;
	private DefaultTableModel model;
	private JTable modTab;
	private JButton btnLoeschen;

	public Mod_Gui() {

		//Layout für diesen Tab setzen
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);


		//Die Titel der Tabellenspalten
		Vector<String> spaltentitel = new Vector<String>();
		spaltentitel.add("Nummer");
		spaltentitel.add("Server");
		spaltentitel.add("Name");
		spaltentitel.add("Forennick");
		spaltentitel.add("Skypenick");


		//Neue DefaultTableModel erstellen und die Spaltentitel hinzufügen			
		model = new DefaultTableModel( spaltentitel, 0 );


		//Daten der Moderatoren in der Tabelle darstellen
		for(int i=0; i < ModListe.getInstance().getModListe().size(); i++){
			Vector<String> zeile = new Vector<String>();
			zeile.add("" + (i+1));
			zeile.add(ModListe.getInstance().getModListe().get(i).getServer());
			zeile.add(ModListe.getInstance().getModListe().get(i).getName());
			zeile.add(ModListe.getInstance().getModListe().get(i).getForennick());
			zeile.add(ModListe.getInstance().getModListe().get(i).getSkypenick());	
			model.addRow(zeile);	
		}



		modTab = new JTable(model);
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
		new NeuerMod(Mod_Gui.this);



	}

	//Daten eines existierenden Mods bearbeiten
	public void modEditieren(){

	}

	//Daten eines Mods löschen
	public void modLoeschen(){
		int size = ModListe.getInstance().getModListe().size();

		//in einem Input-Dialog die Nummer des Moderators abfragen, der gelöscht werden soll
		String nummer = JOptionPane.showInputDialog("Trage die Nummer des Moderators ein, der gelöscht werden soll!");

		//Den String aus dem Dialogfenster in eine Zahl umwandeln (versuchen):
		try{
			int nr = Integer.parseInt(nummer);
			if(nr==0 || nr> size){
				loeschenAbbrechen();
			}

			else{
				nr=nr-1;

				//Aktion im Log festhalten:
				Log.getInstance().getLogger().info("Moderator " + ModListe.getInstance().getModListe().get(nr).getName() + " wird gelöscht!");

				//Moderator aus der ModListe löschen (Package 'Daten')
				ModListe.getInstance().getModListe().remove(nr);

				//Moderator aus der dargestellten Tabelle löschen
				model.removeRow(nr);

				//Moderatoren neu durchnummerieren
				for(int i=0; i < size-1; i++){
					model.setValueAt(i+1, i, 0); 
				}

				//Löschen-Button inaktiv setzen, wenn alle Moderatoren gelöscht wurden
				btnLoeschen.setEnabled(size > 1);
			}

			//Falls keine Zahl eingetragen wurde im Textfeld:
		} catch(NumberFormatException ex){
			loeschenAbbrechen();
		}



	}


	//Falls keine Zahl eingegeben wurde im Textfeld oder eine, welche nicht mit der Liste übereinstimmt, wird
	//der Löschvorgang abgebrochen
	public void loeschenAbbrechen(){

		//Log-Eintrag, dass das Löschen abgebrochen werden muss.
		Log.getInstance().getLogger().error("Im Textfeld wurde nicht die Nummer des Moderators eingetragen!");

		//Dialogfenster für den Benutzer mit dem entsprechenden Hinweis:
		JOptionPane.showMessageDialog(null,
				"Im Textfeld muss die Nummer des Moderators eingetragen werden!",
				"Warnung",                                       
				JOptionPane.WARNING_MESSAGE);
	}


}
