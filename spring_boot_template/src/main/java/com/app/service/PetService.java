package com.app.service;

import java.util.List;

import com.app.dto.PetAddDto;
import com.app.dto.PetResponseDto;

public interface PetService {

	

	public PetResponseDto addPet(PetAddDto petAddDto);

	PetResponseDto getPet(int id);

	//ApiResponse updatePetDetails(PetResponseDto petResponseDto);
	
	void deletePetById(int id);

  List<PetResponseDto> getPetsByCityId(int cityId) ;

public List<PetResponseDto> getAllPetsByPostId(int postId);

public PetResponseDto updatePetDetails(PetResponseDto petDto);

public List<PetResponseDto> getAllPets();
	
	

}
