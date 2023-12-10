package atm.bank.model;

public class BankAccount {

	// ATTRIBUTI

	private int accountNumber;
	private int pin;
	private double balance = 0.0;

	// GETTER & SETTER

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public double getBalance() {
		return balance;
	}

	public void depositMoney(double amount) {
		this.balance += amount;
		System.out.println("+" + amount +" € successfully deposited into your bank account.");
	}

	public void withdrawMoney(double amount) {
		if (amount > balance)
			System.out.println("Insufficient funds. Unable to complete the transaction.");
		else {
			balance -= amount;
			System.out.println("Withdrawal successful. Your new balance is " + balance + "€");
		}
	}

	@Override
	public String toString() {
		return "Smart-Bank\n" + "MasterCard " + accountNumber + "\nBalance: " + balance + " €";
	}

	public BankAccount() {

	}

}
