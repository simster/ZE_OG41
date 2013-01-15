package ch.sipama.GUI;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import ch.sipama.Daten.ModListe;
import ch.sipama.Daten.Moderator;

public class NeuerMod extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Instanzvariablen
	private final Mod_Gui modObject;
	
	private JTextField txtName;
	private JTextField txtForenname;
	private JTextField txtSkypename;
	private JTextField txtServer;
	
	private JButton btnSave;
	private JButton btnAbbrechen;
	private JButton btnBereinigen;
	
	
	//Konstruktor: neues Dialogfenster öffnen
	public NeuerMod( final Mod_Gui modObject){
		
		//Dialogfenster mit dem Moderator-Tab verknüpfen
		this.modObject=modObject;
			
		//Dialogfenster erstellen
		final JDialog neuerMod = new JDialog();
		neuerMod.setTitle("Neuen Moderator erfassen");
		SpringLayout layout = new SpringLayout();
		neuerMod.setLayout(layout);
		neuerMod.setModal(true);
		
		
		//Labels für die Eingabefelder
		JLabel lblName = new JLabel("Name:");
		JLabel lblForenname = new JLabel("Forumsnick:");
		JLabel lblSkypename = new JLabel("Skypenick:");
		JLabel lblServer = new JLabel("Server:");
		
		
		//Textfelder erstellen und mit den Labels verknüpfen
		txtName = new JTextField(30);
		lblName.setLabelFor(txtName);
		txtForenname = new JTextField(30);
		lblForenname.setLabelFor(txtForenname);
		txtSkypename = new JTextField(30);
		lblSkypename.setLabelFor(txtSkypename);
		txtServer = new JTextField(30);
		lblServer.setLabelFor(txtServer);
		
		
		//Buttons hinzufügen
		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				neuerMod.dispose();
			}
		});
		
		btnBereinigen = new JButton("Eingaben löschen");
		btnBereinigen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtForenname.setText("");
				txtSkypename.setText("");
				txtServer.setText("");
			}
		});
		
		btnSave = new JButton("Moderator hinzufügen");
		btnSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Moderator modNeu= new Moderator(txtName.getText(), txtForenname.getText(), txtSkypename.getText(), txtServer.getText());
				ModListe.getInstance().getModListe().add(modNeu);
				Vector<String> zeile = new Vector<String>();
				int size = (ModListe.getInstance().getModListe().size()-1);
				zeile.add("" + (size+1));
				zeile.add(ModListe.getInstance().getModListe().get(size).getServer());
				zeile.add(ModListe.getInstance().getModListe().get(size).getName());
				zeile.add(ModListe.getInstance().getModListe().get(size).getForennick());
				zeile.add(ModListe.getInstance().getModListe().get(size).getSkypenick());	
				modObject.getModel().addRow(zeile);
				neuerMod.dispose();
			}
			
		});
		
		
		//alles dem Dialogfenster hinzufügen
		neuerMod.add(lblName);
		neuerMod.add(txtName);
		neuerMod.add(lblForenname);
		neuerMod.add(txtForenname);
		neuerMod.add(lblSkypename);
		neuerMod.add(txtSkypename);
		neuerMod.add(lblServer);
		neuerMod.add(txtServer);
		neuerMod.add(btnAbbrechen);
		neuerMod.add(btnBereinigen);
		neuerMod.add(btnSave);
		
		
		
		//Die Elemente im Fenster platzieren
		layout.putConstraint(SpringLayout.WEST, lblName, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, lblName, 10, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, txtName, 5, SpringLayout.EAST, lblForenname);
		layout.putConstraint(SpringLayout.NORTH, txtName, 7, SpringLayout.NORTH, this);

		layout.putConstraint(SpringLayout.WEST, lblForenname, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, lblForenname, 7, SpringLayout.SOUTH, txtName);
		
		layout.putConstraint(SpringLayout.WEST, txtForenname, 5, SpringLayout.EAST, lblForenname);
		layout.putConstraint(SpringLayout.NORTH, txtForenname, 5, SpringLayout.SOUTH, txtName);
		
		layout.putConstraint(SpringLayout.WEST, lblSkypename, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, lblSkypename, 7, SpringLayout.SOUTH, txtForenname);
		
		layout.putConstraint(SpringLayout.WEST, txtSkypename, 5, SpringLayout.EAST, lblForenname);
		layout.putConstraint(SpringLayout.NORTH, txtSkypename, 5, SpringLayout.SOUTH, txtForenname);
		
		layout.putConstraint(SpringLayout.WEST, lblServer, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, lblServer, 7, SpringLayout.SOUTH, txtSkypename);
		
		layout.putConstraint(SpringLayout.WEST, txtServer, 5, SpringLayout.EAST, lblForenname);
		layout.putConstraint(SpringLayout.NORTH, txtServer, 5, SpringLayout.SOUTH, txtSkypename);
		
		layout.putConstraint(SpringLayout.WEST, btnBereinigen, 5, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnBereinigen, 220, SpringLayout.SOUTH, this);
		
		layout.putConstraint(SpringLayout.WEST, btnSave, 300, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, btnSave, 220, SpringLayout.SOUTH, this);

		layout.putConstraint(SpringLayout.EAST, btnAbbrechen, -5, SpringLayout.WEST, btnSave);
		layout.putConstraint(SpringLayout.NORTH, btnAbbrechen, 220, SpringLayout.SOUTH, this);


		
		
		
		
		
		neuerMod.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		neuerMod.setBounds(250, 300, 480, 300);
		neuerMod.setMinimumSize(new Dimension(480, 300));
		neuerMod.setVisible(true);
		
		
		
		
		
			
		
	}
	
	
	
	

}
