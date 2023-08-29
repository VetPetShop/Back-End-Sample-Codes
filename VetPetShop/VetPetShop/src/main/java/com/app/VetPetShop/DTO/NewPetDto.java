package com.app.VetPetShop.DTO;

public class NewPetDto {
	
	private Long petId;
	
	private String description;
	
	private int petAge;
	
	private char gender;
	
	private double height;
	
	private double weight;
	
	private String breedName;
	
	private String sellerFirstName;
	
	private String sellerLastName;
	
	private String petColour;
	
	private String medicalDetails;
	
	private double price;

	public NewPetDto(Long petId, String description, int petAge, char gender, double height, double weight,
			String breedName, String sellerFirstName, String sellerLastName, String petColour, String medicalDetails,
			double price) {
		super();
		this.petId = petId;
		this.description = description;
		this.petAge = petAge;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.breedName = breedName;
		this.sellerFirstName = sellerFirstName;
		this.sellerLastName = sellerLastName;
		this.petColour = petColour;
		this.medicalDetails = medicalDetails;
		this.price = price;
	}

	public NewPetDto() {
		super();
	}

	public Long getPetId() {
		return petId;
	}

	public void setPetId(Long petId) {
		this.petId = petId;
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

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getBreedName() {
		return breedName;
	}

	public void setBreedName(String breedName) {
		this.breedName = breedName;
	}

	public String getSellerFirstName() {
		return sellerFirstName;
	}

	public void setSellerFirstName(String sellerFirstName) {
		this.sellerFirstName = sellerFirstName;
	}

	public String getSellerLastName() {
		return sellerLastName;
	}

	public void setSellerLastName(String sellerLastName) {
		this.sellerLastName = sellerLastName;
	}

	public String getPetColour() {
		return petColour;
	}

	public void setPetColour(String petColour) {
		this.petColour = petColour;
	}

	public String getMedicalDetails() {
		return medicalDetails;
	}

	public void setMedicalDetails(String medicalDetails) {
		this.medicalDetails = medicalDetails;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NewPetDto [description=" + description + ", petAge=" + petAge + ", gender=" + gender + ", height="
				+ height + ", weight=" + weight + ", petColour=" + petColour + ", medicalDetails=" + medicalDetails
				+ ", price=" + price + "]";
	}

}
