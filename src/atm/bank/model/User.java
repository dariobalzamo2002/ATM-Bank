package atm.bank.model;

public class User {
	
	// ATTRIBUTI 
	private String firstName;
	private String surname;
	private BankAccount account;
	
	// GETTER & SETTER
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
		
	public BankAccount getAccount() {
		return account;
	}
	
	public void setAccount(BankAccount account) {
		this.account = account;
	}
	
	@Override
	public String toString() {
		return "User: " + firstName + " " + surname + " - Bank Account: " + account;
	}
	
	public User() {
		
	}
	
	public User(String firstName, String surname, String taxIdCode, BankAccount account) {
		super();
		this.account = account;
		this.firstName = firstName;
		this.surname = surname;
	}
	
}