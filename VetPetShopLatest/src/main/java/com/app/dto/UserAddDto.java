package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.app.pojo.PostOffice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAddDto {

	@NotBlank(message = "First name can't be blank")

	private String firstName;
	@NotBlank(message = "Last name can't be blank")

	private String lastName;
	@NotBlank(message = "Email can't be blank")

	private String email;
	@NotBlank(message = "Password can't be blank")

	private String password;
	@NotBlank(message = "Date of Birth can't be blank")

	private LocalDate dob;
	@NotBlank(message = "Gender can't be blank")

	private String gender;
	@NotBlank(message = "Phone number can't be blank")

	private Long phoneNumber;
	@NotBlank(message = "Post Office Id can't be blank")

	private PostOffice postOfficeId;

}
