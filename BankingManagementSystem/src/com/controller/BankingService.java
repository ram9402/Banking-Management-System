package com.controller;

import java.util.Collection;
import java.util.LinkedHashMap;

import com.model.Account;
import com.model.CurrentAccount;
import com.model.Customer;
import com.model.SavingsAccount;

public class BankingService {
	LinkedHashMap<String, Account> accounts = new LinkedHashMap<String, Account>();
	LinkedHashMap<String, Customer> customers = new LinkedHashMap<String, Customer>();
	public void createCustomer(String cid, String cname) {
		if(customers.containsKey(cid)==false) {
			Customer customer = new Customer(cid, cname);
			customers.put(cid, customer);
			System.out.println("Customer creared succesfully....");
		}
		else {
			System.out.println("customer ID already exists....");
		}
		
	}
	public void createAccount(String acc_type, String acc_number, String cus_id, double balance) {
		if(accounts.containsKey(acc_number)==false) {
			if(customers.containsKey(cus_id)==true) {
				if(acc_type.equals("Savings")) {
					Customer customer =customers.get(cus_id);
					Account account = new SavingsAccount(acc_number,customer, balance);
					accounts.put(acc_number, account);
				}
				else if(acc_type.equals("Current")) {
					Customer customer =customers.get(cus_id);
					Account account = new CurrentAccount(acc_number,customer, balance);
					accounts.put(acc_number, account);
				}
				else {
					System.out.println("Invalid account type ");
				}
			}
			else {
				System.out.println("Invalid customer id....");
			}
		
		
	}
	else {
		System.out.println("Account number already exists");
	}

}
	public void withdraw(String withdraw_accno, double withdraw_amount) {
	      if(accounts.containsKey(withdraw_accno)==true) {
	    	  Account account = accounts.get(withdraw_accno);
	    	  account.withdraw(withdraw_amount);
	    	  System.out.println("Amount withdraw successfully....");
	    	  
	      }
	      else {
	    	  System.out.println("Invalid Account number");
	      }
		
	}
	
	public void deposit(String deposit_accno, double deposit_amount) {
		
		 if(accounts.containsKey(deposit_accno)==true) {
	    	  Account account = accounts.get(deposit_accno);
	    	  account.deposit(deposit_amount);
	    	  System.out.println("Amount deposited successfully....");
	    	  
	      }
	      else {
	    	  System.out.println("Invalid Account number");
	      }
	}
	
	public void checkBalance(String view_accno) {
		if(accounts.containsKey(view_accno)==true) {
			Account account =accounts.get(view_accno);
			System.out.println("Your account balance is "+account.getBalance());
		}
		
	}
	public void viewAccounts() {
		Collection<Account> viewaccounts = accounts.values();
		for(Account obj : viewaccounts) {
			System.out.println(obj);
		}
	}
	
	public void deleteAccount(String del_accno) {
		if(accounts.containsKey(del_accno)==true) {
			Account account =accounts.get(del_accno);
			Customer customer = account.getCustomer();
			
			accounts.remove(del_accno);
			customers.remove(customer.getId());
			System.out.println("Account deleted successfuly...");
		}
		else {
			System.out.println("Invalid Account Number");
		}
	}
	
}
