package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.PetAddDto;
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
		Optional<Pet> pet = petRepo.findById(id);
		return modelMapper.map(pet, PetResponseDto.class);

	}

	@Override
	public List<PetResponseDto> getAllPets() {
		List<Pet> pets = petRepo.findAll();
		return pets.stream().map(p -> modelMapper.map(pets, PetResponseDto.class)).collect(Collectors.toList());
	}

//	@Override
//	public List<PetResponseDto> getPetsByCityId(int cityId) {
//		List<Pet> pets = petRepo.findAllByCityId(cityId);
//		return pets.stream().map(p -> modelMapper.map(pets, PetResponseDto.class)).collect(Collectors.toList());
//	}
//
//	@Override
//	public List<PetResponseDto> getAllPetsByPostId(int postId) {
//		List<Pet> pets = petRepo.findAllByPostId(postId);
//
//		return pets.stream().map(p -> modelMapper.map(pets, PetResponseDto.class)).collect(Collectors.toList());
//
//	}

	@Override
	public PetResponseDto updatePetDetails(PetResponseDto petDto) {
		Pet pet = modelMapper.map(petDto, Pet.class);
		petRepo.save(pet);
		return modelMapper.map(pet, PetResponseDto.class);
	}

	@Override
	public void deletePetById(int id) {

		Pet pet = petRepo.findById(id).get();
		petRepo.delete(pet);

	}

}
