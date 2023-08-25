package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSignupDto;
import com.app.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/*
	 * used ResponseEntity just for experience
	 */
	@PostMapping("/userSignUp")
	public ResponseEntity<?> saveUser(@RequestBody UserSignupDto request) throws IOException {

		return new ResponseEntity<>(userService.saveUserDetails(request), HttpStatus.CREATED);
	}

	@GetMapping("/login")
	public ApiResponse AuthenticateUser(@RequestBody UserLoginDto userLoginDto) {
		
		userService.authenticateUser(userLoginDto);
		return new ApiResponse("Login successful");
	}

	@PostMapping("/update-user-details")
	public ApiResponse updateUserDetails(@RequestBody UserDto userDto) {
		userService.updateUserDetails(userDto);
		return new ApiResponse("Details updated successfully");
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateUserDetails(@RequestBody UserDto userDto, @PathVariable int id) {
		System.out.println("in update " + userDto + " " + id);
		// chk if user exists by id
		userService.getUserDetails(id);
		return ResponseEntity.ok(userService.updateUserDetails(userDto));
	}

}
