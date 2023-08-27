package com.app.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "Pets")
public class Pet extends BaseEntity {

	@PrimaryKeyJoinColumn
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	@PrimaryKeyJoinColumn
	@ManyToOne
	@JoinColumn(name = "pet_breed_id")
	private PetBreed petBreedId;

	@PrimaryKeyJoinColumn
	@ManyToOne
	@JoinColumn(name = "pet_Category_Id", nullable = false)
	private PetCategory petCategoryId;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String description;
	
	@Column
	private String imagePath;

	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name="wishlist_id")
	private Wishlist inWishlist;
	
	@Column
	private int age;

	@Column(length = 30)
	private String gender;

	@Column(length = 30)
	private String size;

	@Column
	private boolean vaccinationStatus;

	@Column(length = 30)
	private double price;

	@OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Wishlist> wishlists;
	
	
}
