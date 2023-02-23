package com.rivet.collectionP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SynchonizedArrylist {

	public static void main(String[] args) {
      List<String> Al=Collections.synchronizedList(new ArrayList());
		
		Al.add("pen");
		Al.add("eraser");
		Al.add("ballpen");
		Al.add("sharpner");
		Al.add("scale");
		synchronized(Al){
		Iterator<String> i=Al.iterator();
		
		while(i.hasNext()) {
			
			System.out.println(i.next());
		}
		
	}
	}
}
