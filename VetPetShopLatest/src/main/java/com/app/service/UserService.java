package com.app.service;

import javax.validation.Valid;

import com.app.dto.UserAddDto;
import com.app.dto.UserResponseDto;
import com.app.pojo.User;

public interface UserService {

	UserResponseDto findByEmail(String email);

	UserResponseDto updateUserDetails(UserAddDto userAddDto);

	UserResponseDto addUserDetails(@Valid UserAddDto userAddDto);

//	int numberOfPetsInWishlist(Long wishlistId);

}
