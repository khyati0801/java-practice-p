package practice;

import java.util.ArrayList;
import java.util.ListIterator;



public class TraverseArraylist {

	public static void main(String[] args) {
		ArrayList<String> Al=new ArrayList<String>();
		
		Al.add("pen");
		Al.add("eraser");
		Al.add("ballpen");
		Al.add("sharpner");
		Al.add("scale");
		
		ListIterator<String> Li=Al.listIterator();
		while(Li.hasNext()) {
			
			System.out.println(Li.next());
			
		}
	}
	
	
	
	
	
}
