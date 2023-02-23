package BankApp;

import java.util.Scanner;

public class primeno {

	public static void main(String[] args) {
		int i, count;
		int n = 20;
		System.out.println("Prime numbers between 1 to 20");
		for (int j = 2; j <= n; j++) {
			count = 0;
			for (i = 1; i <= j; i++) {
				if (j % i == 0) {
					count++;
				}
			}
			if (count == 2)
				System.out.print(j + "  ");
		}

	}

}
