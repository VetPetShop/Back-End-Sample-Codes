package com.app.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.ApiResponse;
import com.app.dto.PetAddDto;
import com.app.dto.PetDto;
import com.app.dto.PetResponseDto;
import com.app.pojo.Pet;
import com.app.repository.PetRepository;

@Service
@Transactional
public class PetServiceImpl implements PetService {

	@Autowired
	private PetRepository petRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PetResponseDto addPet(PetAddDto petAddDto) {
		
		Pet pet = modelMapper.map(petAddDto, Pet.class);
		petRepo.save(pet);
		return modelMapper.map(pet, PetResponseDto.class);
		
		
	}

	@Override
	public PetResponseDto getPet(int id) {
		Optional<Pet> pet= petRepo.findById(id);
		return modelMapper.map(pet, PetResponseDto.class);
		
	}

	@Override
	public ApiResponse updatePetDetails(PetDto petDto) {
		Pet pet=modelMapper.map(petDto, Pet.class);
		petRepo.save(pet);
		return new ApiResponse("Updated successfully");
	}

	@Override
	public boolean deletePetById(int id) {
		petRepo.deleteById(id);
		return false;
	}
	
	
	
	
	

	
}
