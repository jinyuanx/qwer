package model;

import java.sql.*;

public class Book {

	private String id;
	private String name;
	private int number;
	private int price;
	
	public 	Book(String id,String name,int number,int price) {
		this.id = id;
		this.name = name;
		this.number = number;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}
