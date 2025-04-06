package com.model;

public class SavingsAccount extends Account {
	private static final double MINIMUM_BALANCE = 5000.00;

	public SavingsAccount(String account_number, Customer customer, double balance) {
		super(account_number, customer, balance);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void withdraw(double amount) {
		if(getBalance()-amount >=MINIMUM_BALANCE) {
			System.out.println("Withdraw success...");
			setBalance(getBalance()- amount);
		}
		else {
			System.out.println("Insufficent balance..");
		}
	}

}
