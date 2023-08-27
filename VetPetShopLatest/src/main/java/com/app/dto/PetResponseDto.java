package com.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PetResponseDto {

	private Long Id;
	private String breedId;
	private String description;

	private int petAge;

	private char gender;

	private String size;

	private Boolean vaccinationStatus;

	private double price;

}
