package com.app.service;

import java.util.List;

import com.app.dto.PetAddDto;
import com.app.dto.PetResponseDto;

public interface PetService {

	PetResponseDto addPet(PetAddDto petAddDto);

	PetResponseDto getPet(int petId);

	List<PetResponseDto> getAllPets();

//	List<PetResponseDto> getPetsByCityId(int cityId);
//
//	List<PetResponseDto> getAllPetsByPostId(int postId);

	PetResponseDto updatePetDetails(PetResponseDto petDto);

	void deletePetById(int petId);

}
