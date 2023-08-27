package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.pojo.PostOffice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Credentials {

	@NotBlank(message = "First Name can't be blank")
	private String firstName;

	@NotBlank(message = "Last Name can't be blank")
	private String lastName;

	@NotBlank(message = "Email can't be blank")
	private String email;

	@NotBlank(message = "Password can't be blank")
	private String password;

	private LocalDate dob;

	private String gender;

	private Long phoneNumber;

	private PostOffice postOfficeId;

}
