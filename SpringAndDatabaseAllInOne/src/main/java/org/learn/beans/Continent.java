package org.learn.beans;

public class Continent {
	int id;
	String name;
	
	public Continent() {
	//	this.name = name;
	}
	
	public Continent(String name) {
		this.name = name;
	}
	
	
	public Continent(int id, String name) {
	
		this.id = id;
		this.name = name;
	}

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
	

}
