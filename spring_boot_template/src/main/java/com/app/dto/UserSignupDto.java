package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Setter
//@Getter
// @ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class UserSignupDto {
	
	
	@NotBlank(message = "First Name can't be blank")

	private String firstName;

	@NotBlank(message = "Last Name can't be blank")
	private String lastName;

	private char gender;

	private LocalDate dob;

	@NotBlank(message = "Email can't be blank")

	private String email;

	@NotBlank(message = "Password can't be blank")

	private String password;

	private String address;

	private String phoneNumber;
	

	
	

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

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public UserSignupDto() {
		super();
	}

}
