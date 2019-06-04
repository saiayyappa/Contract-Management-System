package com.cms.bean;



public class AdminBean {
	private int adminId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String dob;
	private String contactNumber;
	private String altContactNumber;
	private String emailId;
	private String password;
	
	
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getAltContactNumber() {
		return altContactNumber;
	}
	public void setAltContactNumber(String altContactNumber) {
		this.altContactNumber = altContactNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AdminBean [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", dob=" + dob + ", contactNumber=" + contactNumber + ", altContactNumber="
				+ altContactNumber + ", emailId=" + emailId + ", password=" + password + "]";
	}
	
	
}
