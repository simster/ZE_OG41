package ch.sipama.GUI;

import java.awt.BorderLayout;

import javax.swing.*;

public class Tabellen_Gui extends JPanel {
	
	//Instanzvariablen
	private static final long serialVersionUID = 1L;

	public Tabellen_Gui() {
		
		
//		Layout für diesen Tab setzen
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
//		BorderLayout layout= new BorderLayout();
//		this.setLayout(layout);
//		
		String [] columnNames= {"Server","Moderator","Anfang-Zeit","End-Zeit","Dauer"};
		
		Object[][] data = {
			    {"Silberfuchs","Hans", "19:15","22:00","23.05.2012"}};
		
	
	JTable table = new JTable(data, columnNames);
	
	JScrollPane scrollPane = new JScrollPane(table);
	table.setFillsViewportHeight(true);
	
//	layout.setLayout(new BorderLayout());
//	container.add(table.getTableHeader(), BorderLayout.PAGE_START);
//	container.add(table, BorderLayout.CENTER);
	
	layout.putConstraint(SpringLayout.NORTH, table, 30, SpringLayout.NORTH, this);
	layout.putConstraint(SpringLayout.WEST, table, 50, SpringLayout.WEST, this);
	
	layout.putConstraint(SpringLayout.NORTH, table.getTableHeader(), 10, SpringLayout.NORTH, this);
	layout.putConstraint(SpringLayout.WEST, table.getTableHeader(), 50, SpringLayout.WEST, this);
	
	this.add(table);
	this.add(table.getTableHeader());
	}
	
	
}