package com.revature.models;

import java.util.Objects;

public class User {
	private String lasName;
	private String firstName;
	private String emaiAddress;
	private double phoneNumber;
	private String userName;
	private String userPassword;
	
	public User() {
		super();
	}

	public String getLasName() {
		return lasName;
	}

	public void setLasName(String lasName) {
		this.lasName = lasName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmaiAddress() {
		return emaiAddress;
	}

	public void setEmaiAddress(String emaiAddress) {
		this.emaiAddress = emaiAddress;
	}

	public double getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [lasName=" + lasName + ", firstName=" + firstName + ", emaiAddress=" + emaiAddress
				+ ", phoneNumber=" + phoneNumber + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(emaiAddress, firstName, lasName, phoneNumber, userName, userPassword);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(emaiAddress, other.emaiAddress) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lasName, other.lasName)
				&& Double.doubleToLongBits(phoneNumber) == Double.doubleToLongBits(other.phoneNumber)
				&& Objects.equals(userName, other.userName) && Objects.equals(userPassword, other.userPassword);
	}
	
	
	
	
	

}
