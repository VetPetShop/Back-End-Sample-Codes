package com.app.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "wishlists")
public class Wishlist extends BaseEntity {

	
	@OneToOne(mappedBy = "wishlistId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "inWishlist", orphanRemoval = true)
	private List<Pet> petsInWishlist = new ArrayList<>();

	public void addPet(Pet pet) {
		petsInWishlist.add(pet);
		
		pet.setInWishlist(this);
	}
}
