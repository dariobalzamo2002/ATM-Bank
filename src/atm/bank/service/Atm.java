package atm.bank.service;

import atm.bank.model.*;

public final class Atm {

	// ATTRIBUTI
	private static Atm instance = null;
	private final static BankingDatabase DATABASE = BankingDatabase.getInstance(); // Istanza della classe BankingDatabase
	private User[] databaseBankAccount = DATABASE.getDatabaseBankAccount(); // Array di User funge da database

	
	// METODI
	public User authentication(int accountNumber) {
		for (int i = 0; i < databaseBankAccount.length; i++) {
			if (databaseBankAccount[i].getAccount().getAccountNumber() == accountNumber)
				return databaseBankAccount[i];
		}
		return null;
	}

	public boolean checkPin(User user, int pin) {
		if (user.getAccount().getPin() == pin)
			return true;
		return false;
	}

	public static Atm getInstance() {
		if (instance == null)
			instance = new Atm();
		return instance;
	}

	private Atm() {

	}
}
