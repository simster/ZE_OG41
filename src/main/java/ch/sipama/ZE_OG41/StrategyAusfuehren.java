package ch.sipama.ZE_OG41;

public class StrategyAusfuehren {
	
	private Strategy strategy;
	
	public void setStrategy(int i) {
		
		if (i == 1) {
			strategy = new URLAuslesenFile() {
			};
		} else {
			strategy = new URLAuslesen() {
			};
		}
		
	}
	
	
	
//	public void performOperation() {
//		
//	}

}
