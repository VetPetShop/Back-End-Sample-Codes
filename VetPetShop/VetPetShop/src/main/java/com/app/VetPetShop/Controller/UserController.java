package com.app.VetPetShop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.VetPetShop.CustomExceptions.EntityNotFoundException;
import com.app.VetPetShop.DTO.ApiResponse;
import com.app.VetPetShop.DTO.UserLogInDTO;
import com.app.VetPetShop.DTO.UserRequestDto;
import com.app.VetPetShop.DTO.UserResponseDto;
import com.app.VetPetShop.Service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<?> addUser(@RequestBody UserRequestDto user){
		
		try {
			return new ResponseEntity<>(new ApiResponse(userService.registerUser(user)), HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> validateUserLogin(@RequestBody UserLogInDTO user)
	{
		try {
			UserResponseDto validUser = userService.authenticateUser(user);
			return ResponseEntity.ok(validUser);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid User Details !!");
		}
	}
	
	@GetMapping("/get-user")
	public ResponseEntity<?> getUserDetails(@RequestParam String email){
		try {
			UserResponseDto userDetails = userService.getUserDetails(email);
			return ResponseEntity.ok(userDetails);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid User Details !!"); 
		}
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<?> updateUserDetails(@RequestBody UserRequestDto user)
	{
		try {
			return new ResponseEntity<>(new ApiResponse(userService.updateUserDetails(user)), HttpStatus.OK);
		} catch (RuntimeException e) {
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage()));
		}
	}

}
