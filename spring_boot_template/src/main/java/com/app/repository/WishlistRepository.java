package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Pet;
import com.app.pojo.Wishlist;

public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {

	Wishlist findWishlistByUserId(int userId);

	void deletePetById(Pet pet);

	
}
