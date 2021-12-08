package com.models;

public class Person {

	private Long id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	private String address;
	private String cin;
	
	public Person() {
		
	}
	
	public Person(String firstname,String lastname,String email,String phone,String address, String cin) {
		super();
		this.id = 1L + (long) (Math.random() * (10L - 1L));
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.cin = cin;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phone=" + phone + ", address=" + address + ", cin=" + cin + "]";
	}

}
