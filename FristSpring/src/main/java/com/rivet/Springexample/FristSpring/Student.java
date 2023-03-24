package com.rivet.Springexample.FristSpring;

public class Student {
	private int id;
	private String name;
	private Address address;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, Address address) {
		super();
		
		this.id = id;
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
//	public void DisplayStudent()
//	{
//		System.out.println("Student id:"+id);
//		System.out.println("Student Name:"+name);
//		System.out.println("Student Address:"+address);
//	}

	
}
