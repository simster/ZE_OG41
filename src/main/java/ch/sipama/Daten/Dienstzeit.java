package ch.sipama.Daten;

public class Dienstzeit {
	
	private long startzeit;
	private long endzeit;
	private long dauer;
	private Moderator mod;
	
	
	public Dienstzeit(long startzeit, long endzeit, Moderator mod){
		this.startzeit = startzeit;
		this.endzeit = endzeit;
		this.dauer = endzeit-startzeit;
		this.mod = mod;
	}


	public long getStartzeit() {
		return startzeit;
	}


	public void setStartzeit(long startzeit) {
		this.startzeit = startzeit;
	}


	public long getEndzeit() {
		return endzeit;
	}


	public void setEndzeit(long endzeit) {
		this.endzeit = endzeit;
	}


	public long getDauer() {
		return dauer;
	}


	public void setDauer(long dauer) {
		this.dauer = dauer;
	}


	public Moderator getMod() {
		return mod;
	}


	public void setMod(Moderator mod) {
		this.mod = mod;
	}

}
