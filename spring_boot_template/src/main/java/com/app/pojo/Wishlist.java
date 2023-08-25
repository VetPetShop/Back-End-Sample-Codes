package com.app.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "wishlist")
public class Wishlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int wishlistId;

	@OneToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User userId;
	
	@ManyToOne
	@JoinColumn(name = "petId", referencedColumnName = "petId")
	private Pet petId;

//	public User getUserId() {
//		return userId;
//	}
//
//	public void setUserId(User userId) {
//		this.userId = userId;
//	}
//
//	public Pet getPetId() {
//		return petId;
//	}
//
//	public void setPetId(Pet petId) {
//		this.petId = petId;
//	}

	



	
	
}
