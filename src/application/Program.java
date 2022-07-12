package application;

import java.util.Locale;

import entities.Account;
import exceptions.WithdrawException;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		
		Account account = new Account(1234, "welton", 1000.0, 500.0);
		System.out.println(account);
		
		System.out.println("----SAQUE-----");
		
		try {
			account.withdraw(550.0);
		} catch (WithdrawException e) {
			System.out.println("Error in withdraw: " + e.getMessage());
		}
	}

}
