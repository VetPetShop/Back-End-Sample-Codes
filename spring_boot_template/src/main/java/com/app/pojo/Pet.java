package com.app.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Pets")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petId;

	@ManyToOne
	@JoinColumn(name = "breedId", nullable = false)
	private PetBreed breedId;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User userId;

	private List<Pet> pets = new ArrayList<>();

	@Column(nullable = false)
	private int petAge;

	@Column(nullable = false)
	private char gender;

	@Column(nullable = true)
	private String size;

	@Column(columnDefinition = "BOOLEAN DEFAULT false")
	private Boolean vaccinationStatus;

	@Column(nullable = false)
	private double price;

	public void add(Pet pet) {
		pets.add(pet);

	}

//	@Lob
//	private byte[] petImages;

//	public Pet(String description, int petAge, char gender, String size, Boolean vaccinationStatus, double price) {
//		super();
//		this.description = description;
//		this.petAge = petAge;
//		this.gender = gender;
//		this.size = size;
//		this.vaccinationStatus = vaccinationStatus;
//		this.price = price;
//	//	this.petImages = petImages;
//	}
//	
//
//	public Pet() {
//	super();
//}
//
//
//	public int getPetId() {
//		return petId;
//	}
//
//	public void setPetId(int petId) {
//		this.petId = petId;
//	}
//
//	public PetBreed getBreedId() {
//		return breedId;
//	}
//
//	public void setBreedId(PetBreed breedId) {
//		this.breedId = breedId;
//	}
//
//	public String getDescription() {
//		return description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public User getSellerId() {
//		return sellerId;
//	}
//
//	public void setSellerId(User sellerId) {
//		this.sellerId = sellerId;
//	}
//
//	public int getPetAge() {
//		return petAge;
//	}
//
//	public void setPetAge(int petAge) {
//		this.petAge = petAge;
//	}
//
//	public char getGender() {
//		return gender;
//	}
//
//	public void setGender(char gender) {
//		this.gender = gender;
//	}
//
//	public String getSize() {
//		return size;
//	}
//
//	public void setSize(String size) {
//		this.size = size;
//	}
//
//	public Boolean getVaccinationStatus() {
//		return vaccinationStatus;
//	}
//
//	public void setVaccinationStatus(Boolean vaccinationStatus) {
//		this.vaccinationStatus = vaccinationStatus;
//	}
//
//	public double getPrice() {
//		return price;
//	}
//
//	public void setPrice(double price) {
//		this.price = price;
//	}
//
//	
//	/*
//	 *TEMP REQ..USED DTO INSTEAD OF THIS
//	 * public Pets(byte[] imageOfPet, String breedName, char petGender) {
//		this.petImages = imageOfPet;
//		this.breedId.setBreedName(breedName);
//		this.gender = petGender;
//	}
//	 */	

}
