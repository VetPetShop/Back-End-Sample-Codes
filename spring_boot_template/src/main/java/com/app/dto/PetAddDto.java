package com.app.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

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
public class PetAddDto {
	
	private int breedId; 
	
private String description;
	
	@NotBlank(message = "Pet Age can't be blank")
	@Digits(integer = 3, fraction = 0, message = "Age must be a number with at most 3 digits")
	private int petAge;
	
	@NotBlank(message = "Pet Gender can't be blank")
	private char gender;

	private String size;
	
	@NotBlank(message = "Pet's Vaccination status can't be blank")
	private Boolean vaccinationStatus;

	private double price;
}
