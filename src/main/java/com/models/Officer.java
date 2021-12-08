package com.models;

public class Officer extends Person {
	private String password;
	private String entity;
	
	public Officer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Officer(String firstname, String lastname,String email, String phone, String address, String cin, String password, String entity) {
		super(firstname, lastname, email, phone, address, cin);
		this.setPassword(password);
		this.setEntity(entity);
		// TODO Auto-generated constructor stub
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEntity() {
		return entity;
	}
	public void setEntity(String entity) {
		this.entity = entity;
	}
}
