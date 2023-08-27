package com.app.dto;

import java.time.LocalDate;

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
public class UserResponseDto {
	private Long Id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private LocalDate dob;

	private String gender;

	private Long phoneNumber;

	private PostOffice postOfficeId;
}
