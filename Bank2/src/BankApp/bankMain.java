package BankApp;

import java.util.Scanner;

public class bankMain {
	static {
		System.out.println("**welcome to java application**");

	}

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in) ;
			String pwd;
			int Amt,ch;

			BankOP ob1=new BankOP();
				
					//int n;		

				do {
					System.out.println("\nEnter your choice from Following menu in Numbers");
					System.out.println("\nBank Operations:");
					System.out.println(" 1.Create Account \n 2:Deposit \n 3.Withdraw \n 4.CheckBalance \n 5.exit");
					ch=sc.nextInt();				
					
					
					switch(ch) {
						case 1:
								ob1.CreateAcc();
								break;
								
					
						case 2:
							if(ob1.Name== null ) {
					
								System.out.println("user not exist");
								continue;
							}
							else
							{
								System.out.println("Enter your password");
								pwd=sc.next();
								if(pwd.equals(ob1.pass)) {
					
									System.out.println("Enter your amount to Deposit:");
									Amt=sc.nextInt();
									ob1.Deposit(Amt);
					
								}
								else
								{
									System.out.println(" your password is wrong");
									continue;
								}
							}
     
					
							break;
					
						case 3:
							if(ob1.Name== null ) {
			
								System.out.println("user not exist");
								continue;
							}
							else {
								System.out.println("Enter your password");
								pwd=sc.next();
								if(pwd.equals(ob1.pass)) {
					
									System.out.println("Enter your amount to Withdraw:");
									Amt=sc.nextInt();
									ob1.withdraw(Amt);
									ob1.ShoWBalance();
								}
								else
								{
									System.out.println(" your password is wrong");
									continue;
								}
							}		
							break;
					
						case 4:
							if(ob1.Name== null ) {
					
								System.out.println("user not exist");
								continue;
							}
							else {
					
				
								System.out.println("Enter your password");
								pwd=sc.next();
								if(pwd.equals(ob1.pass)) {
									ob1.ShoWBalance();
								}
								else
								{
									System.out.println(" your password is wrong");
									continue;
								}
							}
							break;
					
						case 5:
					
							System.out.println("Exit from banking System");
							System.exit(0);
					
							break;
					
						default:
					
							System.out.println("enter choice 1,2,3,4,5");
					
					}

				}while(ch!=5);
		}
}


