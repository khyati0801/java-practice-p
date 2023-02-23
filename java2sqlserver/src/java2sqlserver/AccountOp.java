package java2sqlserver;

import java.util.Scanner;

public class AccountOp {
	static Scanner sc = new Scanner(System.in);
	static int ch;

	public static void AfterLogin(int id) {

		do {
			System.out.println("\nEnter your choice from Following menu in Numbers");
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Show Balance");
			System.out.println("4.logout");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				Deposit.Deposit1(id);
				break;
			case 2:
				WithDraw.WithDraw(id);
				break;
			case 3:
				ShowCurrentBalance.ShowBalance(id);
				break;
			case 4:
				System.out.println("logout");
				System.exit(0);
			default:
				System.out.println("You Enter Wroung Choice");

			}
		} while (ch != 4);
	}
}
