package practice;

import java.util.ArrayList;
import java.util.Scanner;

public class GivenEArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		
		
		ArrayList<String> Al=new ArrayList<String>();
		
		Al.add("pen");
		Al.add("eraser");
		Al.add("ballpen");
		Al.add("sharpner");
		Al.add("scale");
		
		
		System.out.println(Al);
		
		System.out.println("enter String(element) to check");
		String Str=sc.next();
		
		
		if(Al.contains(Str)) {
			
			System.out.println(Str+"is present in list");
			
		}
		else {
			System.out.println(Str+"is not present in list");
		}
	
	}

}
