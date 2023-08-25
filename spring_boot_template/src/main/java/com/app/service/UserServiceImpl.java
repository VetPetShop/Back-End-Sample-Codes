package com.app.service;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_excceptions.ResourceNotFoundException;
import com.app.custom_excceptions.UserAlreadyExitsException;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSignupDto;
import com.app.pojo.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public String addUser(UserDto user) {

		if (existsByEmail(user.getEmail())) {
			throw new UserAlreadyExitsException("Duplicate signup");
		} else {
			User user1 = modelMapper.map(user, User.class);
			System.out.println(user1.getEmail());
			userRepo.save(user1);

			return "Added Successfully";
		}
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepo.existsByEmail(email);
	}

//ForLogin	
	@Override
	public UserDto authenticateUser(UserLoginDto userLoginDto) {

		User user2 = userRepo.findByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));

		return modelMapper.map(user2, UserDto.class);

	}

	@Override
	public User getUserDetails(int userId) {
		return userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Id Invalid : User not found !!!"));
	}

	@Override
	public UserDto updateUserDetails(UserDto user) {
		if (existsById(user.getUserId())) {
			User user2 = modelMapper.map(user, User.class);
			return modelMapper.map(userRepo.save(user2), UserDto.class);
			// return "Updated Successfully";
//		}
//		return "Error in updating user";
		}
		return user;
	}

	@Override
	public boolean existsById(int id) {
		return userRepo.existsById(id);

	}

	@Override
	public Object saveUserDetails(UserSignupDto request) {
		if (existsByEmail(request.getEmail())) {
			throw new UserAlreadyExitsException("Duplicate signup");
		} else {
			User user1 = modelMapper.map(request, User.class);
			System.out.println(user1.getEmail());
			userRepo.save(user1);

			return "Added Successfully";
		}

	}

}
