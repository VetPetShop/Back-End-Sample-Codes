package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.app.custom_exception.UserAlreadyExistsException;
import com.app.dto.UserAddDto;
import com.app.dto.UserResponseDto;
import com.app.pojo.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	PasswordEncoder enc;

	@Override
	public UserResponseDto findByEmail(String email) {
		Optional<User> user = userRepo.findByEmail(email);
		return modelMapper.map(user, UserResponseDto.class);
	}

	@Override
	public UserResponseDto updateUserDetails(UserAddDto userAddDto) {
		userRepo.save(userAddDto);
		return modelMapper.map(userAddDto, UserResponseDto.class);
	}

	@Override
	public UserResponseDto addUserDetails(@Valid UserAddDto userAddDto) {
		if (userRepo.exitsByEmail(userAddDto.getEmail()))
			throw new UserAlreadyExistsException("User email already exits");
		userAddDto.setPassword(enc.encode(userAddDto.getPassword()));
		userRepo.save(userAddDto);
		return modelMapper.map(userAddDto, UserResponseDto.class);

	}

//	@Override
//	public int numberOfPetsInWishlist(Long wishlistId) {
//		return userRepo.countOfPetsByWishlistId(wishlistId);
//		
//	}

}
