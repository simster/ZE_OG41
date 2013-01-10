package ch.sipama.ZE_OG41;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StrategyAusfuehren {
	
	private Strategy strategy;
	
	public StrategyAusfuehren() throws IOException {
		getText();
		performOperation();
	}
	
	private String getText() throws IOException {
		System.out.println("Type text to output:");
		return readLn();
	}
	
	private String readLn() throws IOException {
		 InputStreamReader input = new InputStreamReader(System.in);
		 BufferedReader reader = new BufferedReader(input);
	     return reader.readLine(); 
	}
	
	public void setStrategy(String i) {
		
		if (i == "1") {
			strategy = new URLAuslesenFile() {
			};
		} else {
			strategy = new URLAuslesen() {
			};
		}
		
	}
	
	public void performOperation() throws IOException {
		System.out.println("setStrategy");
		setStrategy(readLn());
	}

}
