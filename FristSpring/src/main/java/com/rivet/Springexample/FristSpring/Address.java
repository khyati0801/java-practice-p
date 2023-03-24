package com.rivet.Springexample.FristSpring;

public class Address {
	
private int Streetno;
private String Streetname;
private String cityname;
public int getStreetno() {
	return Streetno;
}
public void setStreetno(int streetno) {
	Streetno = streetno;
}
public String getStreetname() {
	return Streetname;
}
public void setStreetname(String streetname) {
	Streetname = streetname;
}
public String getCityname() {
	return cityname;
}
@Override
public String toString() {
	return " [Streetno=" + Streetno + ", Streetname=" + Streetname + ", cityname=" + cityname + "]";
}
public void setCityname(String cityname) {
	this.cityname = cityname;
}
public Address(int streetno, String streetname, String cityname) {
	super();
	Streetno = streetno;
	Streetname = streetname;
	this.cityname = cityname;
}
public Address() {
	super();
	// TODO Auto-generated constructor stub
}

}
