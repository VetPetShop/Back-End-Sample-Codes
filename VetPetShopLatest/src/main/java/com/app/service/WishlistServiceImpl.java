package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exception.ResourceNotFoundException;
import com.app.dto.PetResponseDto;
import com.app.dto.WishlistResponseDto;
import com.app.pojo.Pet;
import com.app.pojo.User;
import com.app.pojo.Wishlist;
import com.app.repository.PetRepository;
import com.app.repository.UserRepository;
import com.app.repository.WishlistRepository;

@Service
@Transactional
public class WishlistServiceImpl implements WishlistService {

	@Autowired
	private WishlistRepository wishlistRepo;

	@Autowired
	private PetRepository petRepo;

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void addToWishList(Long userId, Long petId) {
		if (userRepo.existsById(userId) && petRepo.existsById(petId)) {
			Wishlist wishlist = wishlistRepo.findWishlistByUserId(userId);
			User user = userRepo.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
			Pet pet = petRepo.findById(petId)
					.orElseThrow(() -> new ResourceNotFoundException("Pet not found with id " + petId));

			if (wishlist == null) {
				wishlist = new Wishlist();
				wishlist.setUser(user);
				wishlist.setPet(pet);

			} else {
				wishlist.getPetsInWishlist().add(pet);
				wishlistRepo.save(wishlist);

			}

		}
	}

	@Override
	public void removeFromWishlist(Long userId, Long petId, Long wishlistId) {
		if (userRepo.existsById(userId) && petRepo.existsById(petId) && wishlistRepo.existsById(wishlistId)) {

			wishlistRepo.deletePetById(petId);
		}
	}

	@Override
	public List<WishlistResponseDto> findWishlistByUserId(Long userId) {
	User user=	userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id " + userId));
	Wishlist wishlistId=user.getWishlistId();
	List<Pet> pets= wishlistRepo.findAllPetsByWishlistId(wishlistId);
	return pets.stream().map(p->modelMapper.map(pets, WishlistResponseDto.class)).collect(Collectors.toList());
	}

	@Override
	public Long getCountOfPetsInWishlist(Long userId) {
		User user=	userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found with id " + userId));
		Wishlist wishlistId=user.getWishlistId();
		List<Pet> pets= wishlistRepo.findAllPetsByWishlistId(wishlistId);
		return (long) pets.size();
	}

}
