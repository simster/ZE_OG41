package ch.sipama.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.table.TableColumn;

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
		String[] columnNames = { "Server", "Moderator", "Anfang-Zeit",
				"End-Zeit", "Dauer" };

		Object[][] data = {
				{ "Silberfuchs", "Hans55", "19:15", "22:00", "165" },
				{ "Ikarus", "Urs99", "19:00", "22:15", "195" } };

		JTable table = new JTable(data, columnNames);
		table.setPreferredScrollableViewportSize(new Dimension(600, 300));
		table.setLayout(new FlowLayout());
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);
		
		TableColumn column = null;
		for (int i = 0; i < 4; i++) {
		    column = table.getColumnModel().getColumn(i);
		    if (i == 2 && i==3) {
		        column.setPreferredWidth(60); //third column is bigger
		    } else {
		        column.setPreferredWidth(150);
		    }
		}

		// layout.putConstraint(SpringLayout.NORTH, table, 30,
		// SpringLayout.NORTH,
		// this);
		// layout.putConstraint(SpringLayout.WEST, table, 50, SpringLayout.WEST,
		// this);
		//
		// layout.putConstraint(SpringLayout.NORTH, table.getTableHeader(), 10,
		// SpringLayout.NORTH, this);
		// layout.putConstraint(SpringLayout.WEST, table.getTableHeader(), 50,
		// SpringLayout.WEST, this);

		layout.putConstraint(SpringLayout.NORTH, scrollPane, 5,
				SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.WEST, scrollPane, 5,
				SpringLayout.WEST, this);

		this.add(scrollPane);
	}

}