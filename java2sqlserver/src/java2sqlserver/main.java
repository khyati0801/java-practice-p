package java2sqlserver;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class main {
	static {
		System.out.println("-----WelCome to Bank------");
	}
	public static void main(String[] args)  {
		try {
		int ch;
		UserServiceImp user = new UserServiceImp();

		Scanner sc = new Scanner(System.in);
		Connection getconnection = ContectionTodb.Getconnection();
		
		do {
			System.out.println("\nEnter your choice from Following menu in Numbers");

			System.out.println(
					" 1:Create  New User \n 2:Login to existing account \n 3:Delete User by id \n 4.Display All User \n 5.Get User by id \n 6.Upadate \n 7.exit ");
			ch = sc.nextInt();

			switch (ch) {

			case 1:

				User u1 = new User();
				int id = u1.getId();
				String Name = u1.getName();
				String Add = u1.getAdd();
				long mobileNo = u1.getMobileNo();
				double balance = u1.getBalance();

				user.createUser(u1);

				break;
			case 2:
				System.out.println("Enter user id");
				int Uid = sc.nextInt();
				user.Login(Uid);

				break;
			case 3:
				user.deleteById();
				break;

			case 4:
				user.getAllUser();
				break;

			case 5:
				User u2 = new User();
				System.out.println("Enter user id");
				int id1 = sc.nextInt();

				user.getUserbyID(id1);
				break;

			case 6:
			
				user.updateUser();
				break;

			case 7:
				
				System.out.println("Thank you for using our Services visit Again");
				ContectionTodb.con.close();
				System.exit(0);

			default:
				System.out.println("You Enter Wroung Choice");
			}

		} while (ch != 7);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			
		}
		
	}
}
