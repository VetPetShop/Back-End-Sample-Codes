package com.app.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;

//@Getter
//@Setter
//@ToString
//@NoArgsConstructor
//@AllArgsConstructor
public class PetDto {

	private int petId;
	
	private int breedId; 
	
	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

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

	public int getBreedId() {
		return breedId;
	}

	public void setBreedId(int breedId) {
		this.breedId = breedId;
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

//	@NotBlank(message = "Pet Image can't be blank")
//	@Lob
//	private byte[] petImages;
//	
	
	

}
