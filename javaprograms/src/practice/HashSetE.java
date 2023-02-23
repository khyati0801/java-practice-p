package practice;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetE {

	public static void main(String[] args) {
HashSet<Integer> Hs1=new HashSet<Integer>();
		
        Hs1.add(10);
		Hs1.add(0);
		Hs1.add(20);
		Hs1.add(30);
		Hs1.add(50);
		
		
		System.out.println("using Iterator");
		Iterator<Integer> i=Hs1.iterator();
		while(i.hasNext()) {
			
			System.out.println(i.next());
	
		}
	
		//without using Iterator
		System.out.println("without using Iterator");
	for(Integer j:Hs1) {

		System.out.println(j);
	}

		
}
}


