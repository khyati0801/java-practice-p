package practice;

import java.util.ArrayList;

public class ListToArray {

	public static void main(String[] args) {
	ArrayList<String> Al=new ArrayList<String>();
		
		Al.add("pen");
		Al.add("eraser");
		Al.add("ballpen");
		Al.add("sharpner");
		Al.add("scale");
		
//		String a[]=Al.toArray(new String[Al.size()]);
//		//Object a[]=Al.toArray();
//		for(String b:a) {
//			
//			
//			System.out.println(b);
//		}
//		
		
		String a1[]=new String[Al.size()];
		
		for(int i=0;i<Al.size();i++) {
			
			a1[i]=Al.get(i);
			System.out.println(a1[i]);
			
		}
//		for(String s:a1) {
//			
//			System.out.println(s);
//			
//		}
		
		
	}

}
