package com.app.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

public class PetResponseDto {
	private String breedName;
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

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPetAge() {
		return petAge;
	}

	public void setPetAge(int petAge) {
		this.petAge = petAge;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Boolean getVaccinationStatus() {
		return vaccinationStatus;
	}

	public void setVaccinationStatus(Boolean vaccinationStatus) {
		this.vaccinationStatus = vaccinationStatus;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public PetResponseDto(String breedName, String description,
			@NotBlank(message = "Pet Age can't be blank") @Digits(integer = 3, fraction = 0, message = "Age must be a number with at most 3 digits") int petAge,
			@NotBlank(message = "Pet Gender can't be blank") char gender, String size,
			@NotBlank(message = "Pet's Vaccination status can't be blank") Boolean vaccinationStatus, double price) {
		super();
		this.breedName = breedName;
		this.description = description;
		this.petAge = petAge;
		this.gender = gender;
		this.size = size;
		this.vaccinationStatus = vaccinationStatus;
		this.price = price;
	}

	public PetResponseDto() {
		super();
	}

}
