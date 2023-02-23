package BankApp;

import java.util.Scanner;

public class BankOP {
	protected String Name;
	private long mobile;
	private long Accno;
	private int Balance;
	protected String  pass;
	
	Scanner sc = new Scanner(System.in); 
	
	public void CreateAcc() {
		
		try {
			System.out.println("Enter your Name:");
		 Name=sc.next();
		
		System.out.println("Enter mobile Number:");
		 mobile=sc.nextLong();
		
		System.out.println("Enter Account Number:");
		 Accno=sc.nextLong();
		 
		 System.out.println("Enter Password:");
			pass=sc.next() ;
		
		System.out.println("Enter Amount to Deposit:");
		Balance=sc.nextInt();
		
			Show();
	
		}
		catch(Exception e) {
			
			//
			System.out.println(e);
			sc.nextLine();
			
			CreateAcc();
		}
		
		
					
	}
	public  void Show() {
		System.out.println("Account Created with following Details");
		System.out.println("Name:"+Name+"\nAccountno:"+Accno+"\nMobile:"+mobile+"\nBalance:"+Balance);
		
		
	}
	public void ShoWBalance() {
		
		System.out.println("Current Balance in your Account:"+Balance);
	}
	
	public int  Deposit(int Amt) {
		try (Scanner sc = new Scanner(System.in)) {
			if(Amt <=0 ) {
				System.out.println("you enter wrong amount");
				System.out.println("Enter amount to Deposit");
				Amt=sc.nextInt();
				Deposit(Amt);
				
			}
			else {
				Balance=Balance+Amt;
				ShoWBalance();
			}
		}
			return Balance;
		
		
	}
  public int  withdraw(int Amt) {
	  try (Scanner sc = new Scanner(System.in)) {
		if(Amt<=0) {
			System.out.println("you enter wrong amount");
			System.out.println("Enter amount to withdraw");
			Amt=sc.nextInt();
			withdraw(Amt);
		}
		else if(Amt > Balance  ) {
				System.out.println("can't withdraw insufficient balance in your Account  "+Balance);
				System.out.println("Enter amount to withdraw");
				Amt=sc.nextInt();
				withdraw(Amt);
				//return Balance;
			}
			else {
			 Balance=Balance-Amt;
			}
	} 
		return Balance;
	}
}
