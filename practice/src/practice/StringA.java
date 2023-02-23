package practice;

import java.util.Arrays;
import java.util.Scanner;

public class StringA {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1,s2;
		
		//to enter two string
		System.out.println("Enter two Strings");
		s1=sc.next();
		s2=sc.next();

		s1=s1.toLowerCase();
		s2=s2.toLowerCase();

		System.out.println(s1+" \n "+s2);

		if(s1.length()!=s2.length()){

			System.out.println("Both Are not Anagram");
		}
		else{
			//convert into char array
			char[] str1=s1.toCharArray();
			char[] str2=s2.toCharArray();

			//sort
			Arrays.sort(str1);
			Arrays.sort(str2);

			if(Arrays.equals(str1,str2)==true)
			{
				System.out.println("Both Are  Anagram");
			}
			else{
				System.out.println("Both Are not Anagram");
			}

			
		}
	}

	}


