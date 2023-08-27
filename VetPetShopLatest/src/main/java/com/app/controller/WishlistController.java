package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.PetService;
import com.app.service.UserService;
import com.app.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:3000")
public class WishlistController {

	@Autowired
	WishlistService wishlistService;

	@Autowired
	PetService petService;

	@Autowired
	UserService userService;

	@PostMapping("/add-to-wishlist/{userId}/{petId}")
	public ResponseEntity<?> addToWishlist(@PathVariable Long userId, @PathVariable Long petId) {
		wishlistService.addToWishList(userId, petId);
		return ResponseEntity.ok("Added to wishlist");
	}

	@DeleteMapping("/remove-from-wishlist/{userId}/{petId}/{wishlistId}")
	public ResponseEntity<?> removeFromWishlist(@PathVariable Long userId, @PathVariable Long petId,
			@PathVariable Long wishlistId) {
		wishlistService.removeFromWishlist(userId, petId, wishlistId);
		return ResponseEntity.ok("Pet removed Successfully");
	}

	@GetMapping("/get-wishlist/{userId}")
	public ResponseEntity<?>  getWishlist(@PathVariable Long userId) {
		return new ResponseEntity<>(wishlistService.findWishlistByUserId(userId), HttpStatus.OK);
	}
	
	
	@GetMapping("/countOfPetsInWishlist/{userId")
	public ResponseEntity<?>  countPetsInWishlist(@PathVariable Long userId) {
		return new ResponseEntity<>(wishlistService.getCountOfPetsInWishlist(userId),HttpStatus.OK);
		
	}

}
