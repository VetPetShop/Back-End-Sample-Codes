package com.app.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//import lombok.ToString;
//
//@Setter
//@Getter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class UserLoginDto {
	//@NotBlank(message = "Email can't be blank")

	private String email;

	//@NotBlank(message = "Password can't be blank")
	@Length(min = 6, max = 20, message = "Invalid password length")
	private String password;

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
	
}
