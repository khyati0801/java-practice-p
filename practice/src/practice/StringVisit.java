package practice;

import java.util.Scanner;

public class StringVisit {

	public static void main(String[] args) {
		System.out.println("enter String");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		int count = 0;
		char a[] = s.toCharArray();
		System.out.println(s);

		int n[] = new int[20];

		for (int i = 0; i < a.length - 1; i++) {
			n[i] = 1;
			for (int j = i + 1; j < a.length; j++) {

				if (a[i] == a[j]) {

					n[i]++;
					a[j] = '0';

				}

			}

		}
		for (int i = 0; i < a.length - 1; i++) {

			if (a[i] != ' ' && a[i] != '0') {
				System.out.println(a[i] + " " + n[i]);
			}
		}

	}

}
