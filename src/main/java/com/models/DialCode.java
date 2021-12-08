package com.models;

public class DialCode {
	private String name;
	private String dial_code;
	private String code;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDial_code() {
		return dial_code;
	}
	public void setDial_code(String dial_code) {
		this.dial_code = dial_code;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@Override
	public String toString() {
		return "DialCode [name=" + name + ", dial_code=" + dial_code + ", code=" + code + "]";
	}

}
