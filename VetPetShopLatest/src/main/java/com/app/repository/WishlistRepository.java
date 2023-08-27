package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojo.Pet;
import com.app.pojo.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

	Wishlist findWishlistByUserId(Long userId);

	void deletePetById(Long petId);

	 List<Pet> findAllPetsByWishlistId(Wishlist wishlistId);

	

}
