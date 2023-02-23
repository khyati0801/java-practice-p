package com.rivet.collectionP;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

class employee {
	String Name;
	private long id;
	private int salary;
	
	employee(String Name,int salary,long id){
		
		this.Name=Name;
		this.id=id;
		this.salary=salary;
	}
	
	@Override
	public String toString() {
		return "{" + Name +"," +id+","+salary+ "}";
			
	}
}
class mycomparator implements Comparator<employee>{

	

	@Override
	public int compare(employee o1, employee o2) {
		
		return -o1.Name.compareTo(o2.Name);
	}
	
}

public class ArrayListcomcoparator  {

	public static void main(String[] args) {
		ArrayList<employee> ob=new ArrayList<employee>();
		
	
		ob.add(new employee("Nitya", 02, 10000));
		ob.add(new employee("Jatin", 01, 11000));
		ob.add(0, new employee("Khyati", 03, 30000));
		//Comparator<employee> s=new Comparator<employee>();
		Collections.sort(ob, new mycomparator());
		
	
		Iterator i=ob.iterator();
		while(i.hasNext()) {
				System.out.print(i.next());
		}

		
	}}
