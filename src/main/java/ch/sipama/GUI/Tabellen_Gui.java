package ch.sipama.GUI;

/*
 * @ author  Marco
 */

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.TableColumn;

import ch.sipama.Daten.ModListe;

public class Tabellen_Gui extends JPanel {

	// Instanzvariablen
	private static final long serialVersionUID = 1L;

	public Tabellen_Gui() {

		// Layout für diesen Tab setzen
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		// BorderLayout layout= new BorderLayout();
		// this.setLayout(layout);
		//

		// Die Titel der Tabellenspalten
		// Vector<String> spaltentitel = new Vector<String>();
		// spaltentitel.add("Server");
		// spaltentitel.add("Moderator");
		// spaltentitel.add("Anfang-Zeit");
		// spaltentitel.add("End-Zeit");
		// spaltentitel.add("Dauer");

		String[] columnNames = { "Server", "Moderator", "Anfang-Zeit",
				"End-Zeit", "Dauer" };

		Object[][] data =

		{
				{ ModListe.getInstance().getModListe().get(0).getServer(),
						ModListe.getInstance().getModListe().get(0).getName(),
						"19:15", "22:00", "165" },
				{ ModListe.getInstance().getModListe().get(1).getServer(),
						ModListe.getInstance().getModListe().get(1).getName(),
						"19:15", "22:00", "165" },
				{ ModListe.getInstance().getModListe().get(2).getServer(),
						ModListe.getInstance().getModListe().get(2).getName(),
						"19:15", "22:00", "165" } };

		// { "Silberfuchs",
		// ModListe.getInstance().getModListe().get(0).getName(), "19:15",
		// "22:00", "165" },
		// { "Ikarus", ModListe.getInstance().getModListe().get(1).getName(),
		// "19:00", "22:15", "195" } };

		JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(600, 300));
		table.setLayout(new FlowLayout());
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);

		TableColumn column = null;
		for (int i = 0; i < 4; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 2 && i == 3) {
				column.setPreferredWidth(60); // third column is bigger
			} else {
				column.setPreferredWidth(150);
			}
		}

		layout.putConstraint(SpringLayout.NORTH, scrollPane, 5,
				SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 5,
				SpringLayout.WEST, this);

		this.add(scrollPane);
	}

}