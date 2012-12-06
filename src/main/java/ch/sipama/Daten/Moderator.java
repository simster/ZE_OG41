package ch.sipama.Daten;

import java.io.Serializable;

public class Moderator implements Serializable{
	
	//Instanzvariablen
	private static final long serialVersionUID = 1L;
	private String name;
	private String forennick;
	private String skypenick;
	private String server;
	
	
	//Konstruktor um einen neuen Datensatz für einen Moderator zu erstellen
	public Moderator(String name, String forennick, String skypenick, String server){
		this.name = name;
		this.forennick = forennick;
		this.skypenick = skypenick;
		this.server = server;
	}
	
	//Getter- und Settermethoden für die Instanzvariablen
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getForennick() {
		return forennick;
	}
	public void setForennick(String forennick) {
		this.forennick = forennick;
	}
	public String getSkypenick() {
		return skypenick;
	}
	public void setSkypenick(String skypenick) {
		this.skypenick = skypenick;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
}
