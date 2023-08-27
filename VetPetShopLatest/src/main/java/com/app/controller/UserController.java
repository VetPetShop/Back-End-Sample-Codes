package com.app.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.AuthRequest;
import com.app.dto.AuthResp;
import com.app.dto.UserAddDto;
import com.app.jwt_utils.JwtUtils;
import com.app.pojo.User;
import com.app.service.CustomUserDetails;
import com.app.service.UserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {
	@Autowired
	UserService userService;
	@Autowired
	ModelMapper modelMapper;

	@Autowired
	JwtUtils utils;
	@Autowired
	AuthenticationManager manager;

	@PostMapping("/signup")
	public ResponseEntity<?> userRegistration(@RequestBody @Valid UserAddDto userAddDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUserDetails(userAddDto));
	}

	@PostMapping("login")
	public ResponseEntity<?> validateUserCreateToken(@RequestBody @Valid AuthRequest request) {
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(request.getEmail(),
				request.getPassword());
		log.info("auth token" + authToken);
		Authentication authentication = manager.authenticate(authToken);
		log.info("auth token again" + authentication.getPrincipal().getClass());
		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

		User user = userDetails.getUser();
		AuthResp resp = modelMapper.map(user, AuthResp.class);
		resp.setToken(utils.generateJwtToken(authentication));
		return ResponseEntity.ok(resp);

	}

	@PostMapping("/update-user")
	public ResponseEntity<?> updateUser(@RequestBody UserAddDto userAddDto) {

		return new ResponseEntity<>(userService.updateUserDetails(userAddDto), HttpStatus.OK);
	}

//	@GetMapping("/numberOfPetsInWishlist/{wishlistId}")
//	public ResponseEntity<?> countInWishlist(@PathVariable Long wishlistId){
//		int count=userService.numberOfPetsInWishlist(wishlistId);
//		return ResponseEntity.ok(count);
//	}
	
	

}
