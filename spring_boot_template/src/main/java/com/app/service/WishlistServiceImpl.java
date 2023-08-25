package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.app.custom_excceptions.ResourceNotFoundException;
import com.app.pojo.Pet;
import com.app.pojo.User;
import com.app.pojo.Wishlist;
import com.app.repository.PetRepository;
import com.app.repository.UserRepository;
import com.app.repository.WishlistRepository;

public class WishlistServiceImpl implements WishlistService {
	@Autowired
	private WishlistRepository wishlistRepo;

	@Autowired
	private PetRepository petRepo;

	@Autowired
	private UserRepository userRepo;

	public void addToWishlist(int userId, int petId) {
		if (userRepo.existsById(userId) && petRepo.existsById(petId)) {
			Wishlist wishlist = wishlistRepo.findWishlistByUserId(userId);
			User user = userRepo.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
			Pet pet = petRepo.findById(petId)
					.orElseThrow(() -> new ResourceNotFoundException("Pet not found with id " + petId));
			if (wishlist == null) {
				wishlist = new Wishlist();
				wishlist.setUserId(user);
				wishlist.setPetId(pet);

			}
			wishlist.getPetId().add(pet);
			wishlistRepo.save(wishlist);
		}

	}

	@Override
	public void removeFromWishlist(int userId, int petId, int wishlistId) {
		if (userRepo.existsById(userId) && petRepo.existsById(petId)&& wishlistRepo.existsById(wishlistId)) {
			Pet pet=petRepo.findByUserIdAndPetId(userId,petId).orElseThrow(()->new ResourceNotFoundException("Pet not found with id " + petId));
			wishlistRepo.deletePetById(pet);;	
			}

		
	}

}
