package com.training.entity;

public class Register {
	String firstName;
	String lastName;
	String typeOfUser;
	String userName;
	String passWord;
	long phoneNumber;
	
	public Register() {
		super();

	}

	public Register(String firstName, String lastName, String typeOfUser, String userName, String passWord,
			long phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.typeOfUser = typeOfUser;
		this.userName = userName;
		this.passWord = passWord;
		this.phoneNumber = phoneNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTypeOfUser() {
		return typeOfUser;
	}

	public void setTypeOfUser(String typeOfUser) {
		this.typeOfUser = typeOfUser;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Register [firstName=" + firstName + ", lastName=" + lastName + ", typeOfUser=" + typeOfUser
				+ ", userName=" + userName + ", passWord=" + passWord + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

	}
