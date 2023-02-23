package com.rivet.collectionP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class HasmapSorting {
	

	public static void main(String[] args) {
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		LinkedHashMap<Integer,String> lmap=new LinkedHashMap<Integer,String>();
		ArrayList<String> list=new ArrayList<String>();
		map.put(15, "gracy");
		map.put(25, "bijal");
		map.put(31, "ronak");
		map.put(20,"darshti");
		
		
		
		
		TreeMap<Integer,String> Tm=new TreeMap<Integer,String>(map);
		
		Iterator i=Tm.keySet().iterator();
		
		//Bake
		while(i.hasNext()) {
			int key=(int)i.next();
			
			
			System.out.println(key+""+map.get(key));
			
		}
		
		//Bevel
		for(Map.Entry<Integer, String> Emap:map.entrySet()) {
			
			list.add(Emap.getValue());
		}	
		
		Collections.sort(list,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		});
		for(String Str:list) {
			
			for(Entry<Integer, String> entry:map.entrySet()) {
				
				if(entry.getValue().equals(Str)) {
					
					
					lmap.put(entry.getKey(), Str);
				}
				
			}
			
			
		}
		System.out.println(lmap);
		

	}

}
