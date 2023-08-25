package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {
	@Autowired
	private WishlistService wishlistService;
	
	
	@PostMapping("/wishlist/{userId}/{petId}")
	public ResponseEntity<String> addToWishlist(@PathVariable int userId, @PathVariable int petId) {
	    wishlistService.addToWishlist(userId, petId);
	    return ResponseEntity.ok("Pet added to wishlist");
	}
	
	@DeleteMapping("/remove-from-wishlist/{userId}/{petId}/{wishlistId}")
	public ResponseEntity<String> removeFromWishlist(@PathVariable int userId,@PathVariable int petId,@PathVariable int wishlistId){
		wishlistService.removeFromWishlist(userId,petId,wishlistId);
		return ResponseEntity.ok("Pet removed from wishlist");
	}
	
}
