package com.app.service;

import java.util.List;

import com.app.dto.WishlistResponseDto;

public interface WishlistService {

	void addToWishList(Long userId, Long petId);

	void removeFromWishlist(Long userId, Long petId, Long wishlistId);

	List<WishlistResponseDto> findWishlistByUserId(Long userId);

	Long getCountOfPetsInWishlist(Long userId);


}
