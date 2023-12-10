package atm.bank.service;

import atm.bank.model.*;

// PATTERN SINGLETON
public final class BankingDatabase {

	// ATTRIBUTI
	
	private static BankingDatabase instance = null;
	private User[] databaseBankAccount = new User[2];
	private User user = null;
	
	// METODI/FUNZIONALITA'
	
	public User[] getDatabaseBankAccount() {
		return databaseBankAccount;
	}
	
	public void insertUser() {
		user = new User();
		user.setFirstName("Dario");
		user.setSurname("Balzamo");
		BankAccount account = new BankAccount();
		account.setAccountNumber(1120231000);
		account.setPin(1010);
		user.setAccount(account);
		
		databaseBankAccount[0] = user;
		
		user = new User();
		user.setFirstName("Maria");
		user.setSurname("Bianchi");
		account = new BankAccount();
		account.setAccountNumber(1120231001);
		account.setPin(1011);
		user.setAccount(account);
		databaseBankAccount[1] = user;
	}
	
	public static BankingDatabase getInstance() {
		if (instance == null)
			instance = new BankingDatabase();
		return instance;
	}

	private BankingDatabase() {

	}

}