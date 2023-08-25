package com.app.service;

public interface WishlistService {

	public void addToWishlist(int userId, int petId)	;

	public void removeFromWishlist(int userId, int petId, int wishlistId);	

	
}
