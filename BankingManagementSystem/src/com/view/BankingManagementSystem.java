package com.view;

import java.util.Scanner;

import com.controller.BankingService;

public class BankingManagementSystem {
	public static void main(String[] args) {
		BankingService service = new BankingService();
		Scanner scanner = new Scanner(System.in);
		System.out.println("***********************************");
		System.out.println("*********** Welcome to*************");
		System.out.println("*******Banking Managment System****");
		System.out.println("***********************************");
		
		while(true) {
			System.out.println("1. Create customer");
			System.out.println("2. Create Account");
			System.out.println("3. Withdraw Amount");
			System.out.println("4. Deposit Amount");
			System.out.println("5. View Balance");
			System.out.println("6. View Acoounts");
			System.out.println("7. Delete Account");
			
			int choice = scanner.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Customer ID: ");
				String cid =scanner.next();
				System.out.println("Enter Customer Name: ");
				String cname =scanner.next();
				service.createCustomer(cid, cname);
				break;
			case 2:
				System.out.println("Enter account type: Savings/Current");
				String acc_type =scanner.next();
				System.out.println("Enter Account Number");
				String acc_number=scanner.next();
				System.out.println("Enter Customer ID: ");
				String cus_id =scanner.next();
				System.out.println("Enter Intial Balance");
				double balance =scanner.nextDouble();
				service.createAccount(acc_type, acc_number, cus_id, balance);
				break;
			case 3:
				System.out.println("Enter Account NUmber: ");
				String withdraw_accno = scanner.next();
				System.out.println("Enter Amount: ");
				double withdraw_amount = scanner.nextDouble();
				service.withdraw(withdraw_accno, withdraw_amount);
				break;
			case 4:
				System.out.println("Enter Account Number: ");
				String deposit_accno = scanner.next();
				System.out.println("Enter Amount");
				double deposit_amount = scanner.nextDouble();
				service.deposit(deposit_accno, deposit_amount);
				break;
			case 5:
				System.out.println("Enter account Number");
				String view_accno = scanner.next();
				service.checkBalance(view_accno);
				break;
			case 6:
				service.viewAccounts();
				break;
			case 7:
				System.out.println("Enter account number: ");
				String del_accno =scanner.next();
				service.deleteAccount(del_accno);
				
			case 8:
				System.exit(0);
			default:
				System.out.println("Enter a valid option");
				break;
				
			}
		}
		
	}

}
