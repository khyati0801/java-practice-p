package com.rivet.collectionP;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class linkedlisttoArrayList {

	public static void main(String[] args) {
LinkedList<String> Linl=new LinkedList<String>();
		
		Linl.add("apple");
		Linl.add("banana");
		Linl.add("lichi");
		Linl.add("pineaple");
		Linl.add("chery");
		
		
		ArrayList al=new ArrayList(Linl);
		
		for(Object str:al) {
			System.out.println(str);
		}
		
	}

}
