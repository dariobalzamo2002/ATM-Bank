package atm.bank.view;

import atm.bank.model.User;

public final class Display {

	private static Display instance = null;
	
	public void displayATM(){
		System.out.println("##############  ATM ##############");
		System.out.println("__________________________________");
		System.out.println("Please, insert your account number: ");
	}
	
	public void displayAccount(User user) {
		System.out.println("##### Welcome in Smart-Bank ######");
		System.out.println("##### --------------------- ######");
		System.out.println("#\t" + "User: " + user.getFirstName() + " " + user.getSurname());
		System.out.println("#\t" + "account number: " + user.getAccount().getAccountNumber());
		System.out.println("# [1] My balance");
		System.out.println("# [2] Deposit money");
		System.out.println("# [3] Withdraw money");
		System.out.println("# [0] Log-out");
		System.out.println("#________________________________#");
		System.out.println("Enter: ");
	}
	
	public void DisplayMessage(String message) {
		System.out.println(message);
	}
	
	public static Display getInstance() {
		if(instance == null)
			instance = new Display();
		return instance;
	}
	
	private Display() {
		
	}
}
