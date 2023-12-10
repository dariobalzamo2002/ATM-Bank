package atm.bank.view;

import java.util.Scanner;

public final class Keypad {

	private static Keypad instance = null;
	
	
	public String getInput() {
		Scanner input = new Scanner(System.in);
		return input.nextLine();
	}
	
	public static Keypad getInstance() {
		if(instance == null) 
			instance = new Keypad();
		return instance;
	}
	
	private Keypad() {
		
	}
}
