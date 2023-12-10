package atm.bank.controller;

import atm.bank.model.User;
import atm.bank.service.Atm;
import atm.bank.service.BankingDatabase;
import atm.bank.view.*;

//	PROGRAMMA BANK ATM

public final class Controller {

	// VARIABILI PROGRAMMA
	private final static Display DISPLAY = Display.getInstance();
	private final static Keypad KEYPAD = Keypad.getInstance();
	private final static Atm atm = Atm.getInstance();
	private final static BankingDatabase DATABASE = BankingDatabase.getInstance();

	public static void main(String[] args) {

		// VARIABILI LOCALI
		short choice;
		int accountNumber, pin;
		User user = null;
		double amount;
		boolean flag;

		
		// BUSINESS LOGIC
		DATABASE.insertUser();
		
		DISPLAY.displayATM();
		accountNumber = Integer.parseInt(KEYPAD.getInput());
		user = atm.authentication(accountNumber);
		
		while (user == null) { // CICLO DI VALIDAZIONE PER L'AUTENTICAZIONE DELL'ACCOUNT
			DISPLAY.DisplayMessage("Bank account not found");
			DISPLAY.displayATM();
			accountNumber = Integer.parseInt(KEYPAD.getInput());
			user = atm.authentication(accountNumber);
		}
		
		do {
			DISPLAY.displayAccount(user);
			choice = Short.parseShort(KEYPAD.getInput());
			switch (choice) {
			case 1: // My balance
				DISPLAY.DisplayMessage("Balance: " + user.getAccount().getBalance() + " €");
				break;
			case 2: // Deposit money
				DISPLAY.DisplayMessage("insert banknotes");
				amount = Double.parseDouble(KEYPAD.getInput());
				do {
					DISPLAY.DisplayMessage("Enter the pin");
					pin = Integer.parseInt(KEYPAD.getInput());
					if (atm.checkPin(user,pin)) {
						user.getAccount().depositMoney(amount);
						flag = false;
					} else {
						DISPLAY.DisplayMessage("Invalid pin");
						flag = true;
					}
				} while (flag);
				break;
			case 3: // Withdraw money
				DISPLAY.DisplayMessage("insert amount to withdraw");
				amount = Double.parseDouble(KEYPAD.getInput());
				do {
					DISPLAY.DisplayMessage("Enter the pin");
					pin = Integer.parseInt(KEYPAD.getInput());
					if (atm.checkPin(user,pin)) {
						user.getAccount().withdrawMoney(amount);
						flag = false;
					} else {
						DISPLAY.DisplayMessage("Invalid pin");
						flag = true;
					}
				} while (flag);
				break;
			}
		} while (choice != 0);
		DISPLAY.DisplayMessage("Log-out account... \nBye by Smart-Bank.");
	}
}