package BankSystem;

import java.util.Scanner;

class BankAccount{
	double bal;
	double prevTrans;
	String customerId;
	String customerName;
	
	BankAccount(String customerId, String customerName){
		this.customerId = customerId;
		this.customerName = customerName;
	}
	
	void deposit(double amount){
		if (amount !=0) {
			bal += amount;
			prevTrans = amount;
		}
	}
	
	void withdraw(double amount) {
		if (amount != 0 && bal>amount) {
			bal -= amount;
			prevTrans = -amount;
		}
		if (bal<amount) {
			System.out.println("Bank Balance Insufficient");
		}
	}
	
	void prevTrans() {
		if (prevTrans>0) {
			System.out.println("Deposited : "+prevTrans);
		}
		else if (prevTrans<0) {
			System.out.println("Withdrawn : "+Math.abs(prevTrans));
		} 
		else {
			System.out.println("No Transaction Occured ! ");
		}
	}
	
	void menu() {
		char option;
		Scanner  sc = new Scanner(System.in);
		System.out.println("WELCOME "+ customerName);
		System.out.println("Your ID : "+customerId);
		System.out.println();
		System.out.println("a) Check Balance");
		System.out.println("b) Deposit Amount");
		System.out.println("c) Withdraw Amount");
		System.out.println("d) Previous Transaction");
		System.out.println("e) Exit");
		
		do {
			System.out.println("************************");
			System.out.println("Choose Option");
			option = sc.next().charAt(0);
			System.out.println();
			
			switch (option) {
			case 'a': 
				System.out.println("........................");
				System.out.println("Your Balance Is : "+bal);
				System.out.println("........................");
				System.out.println();
				break;
			case 'b': 
				System.out.println("........................");
				System.out.println("Enter Amount To Deposit : ");
				System.out.println("........................");
				double amtD =sc.nextDouble();
				deposit(amtD);
				System.out.println();
				break;
			case 'c': 
				System.out.println("........................");
				System.out.println("Enter Amount To Withdraw : ");
				System.out.println("........................");
				double amtW =sc.nextDouble();
				withdraw(amtW);
				System.out.println();
				break;
			case 'd':
				System.out.println("........................");
				System.out.println("Prevoius Transcations : ");
				prevTrans();
				System.out.println("........................");
				System.out.println();
				break;
			case 'e':
				break;
			
			default:
				System.out.println("Enter A Valid Option To Proceed!");
			}	
		} while (option!='e');
		
		System.out.println(".........Thank You......Visit Again..........");
	}
}

public class BankManagementSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your 'Name' And Customer ID: ");
		String name = sc.nextLine();
		String id = sc.nextLine();
		BankAccount A1 = new BankAccount(id, name);
		A1.menu();
	}
}
