package com.app.pojo;

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
@Table(name = "PetBreed")
public class PetBreed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petBreedId;

	@Column
	private String breedName;

	@ManyToOne
	@JoinColumn(name = "petCategoryId")
	private PetCategory petCategoryId;

	public PetBreed(String breedName) {
		super();
		this.breedName = breedName;
	}
}
