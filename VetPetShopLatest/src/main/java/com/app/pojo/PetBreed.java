package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "pet_Breed")
public class PetBreed extends BaseEntity{
	
@Column
private String breedName;
@PrimaryKeyJoinColumn
@ManyToOne
@JoinColumn(name = "breed_category_Id", nullable = false)
private PetCategory petCategoryId;

@OneToMany(mappedBy = "petBreedId", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Pet> pets;
}
