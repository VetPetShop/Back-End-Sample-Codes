package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "PetCategory")
public class PetCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int petCategoryId;

	@Enumerated(EnumType.STRING)
	private PetCategoryEnum petCategory;

	public PetCategory(PetCategoryEnum petCategory) {
		super();
		this.petCategory = petCategory;
	}
}
