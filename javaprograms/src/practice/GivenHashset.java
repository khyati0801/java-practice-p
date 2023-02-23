package practice;


import java.util.HashSet;
import java.util.Scanner;

public class GivenHashset {

public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
		
		
		
		HashSet<String> Hset=new HashSet<String>();
		
		Hset.add("pen");
		Hset.add("eraser");
		Hset.add("ballpen");
		Hset.add("sharpner");
		Hset.add("scale");
		
		
		System.out.println(Hset);
		
		System.out.println("enter String(element) to check");
		String Str=sc.next();
		
		
		if(Hset.contains(Str)) {
			
			System.out.println(Str+"is present in hashset");
			
		}
		else {
			System.out.println(Str+"is not present in hashset");
		}
	
	}


	}

