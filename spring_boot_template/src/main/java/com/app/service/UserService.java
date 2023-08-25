package com.app.service;

import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSignupDto;
import com.app.pojo.User;

public interface UserService {

	String addUser(UserDto userDto);

	UserDto authenticateUser(UserLoginDto userLoginDto);

	boolean existsByEmail(String email);

	UserDto updateUserDetails(UserDto userDto);

	User getUserDetails(int userId);
	boolean existsById(int id);

	Object saveUserDetails(UserSignupDto request);

}
