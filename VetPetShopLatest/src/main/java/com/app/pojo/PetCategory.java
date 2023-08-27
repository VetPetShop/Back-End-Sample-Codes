package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
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
@Table(name = "pet_category")
public class PetCategory extends BaseEntity{

	@Enumerated(EnumType.STRING)
	private PetCategoryEnum petCategory;
	
	@OneToMany(mappedBy = "petCategoryId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<PetBreed> petBreeds;

	@OneToMany(mappedBy = "petCategoryId", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Pet> pets; 
}
