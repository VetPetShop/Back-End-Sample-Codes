package com.app.service;

import java.util.Optional;

import com.app.dto.ApiResponse;
import com.app.dto.PetAddDto;
import com.app.dto.PetDto;
import com.app.dto.PetResponseDto;
import com.app.pojo.Pet;

public interface PetService {

	

	public PetResponseDto addPet(PetAddDto petAddDto);

	PetResponseDto getPet(int id);

	ApiResponse updatePetDetails(PetDto petDto);
	
	boolean deletePetById(int id);

}
