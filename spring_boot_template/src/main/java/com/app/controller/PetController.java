package com.app.controller;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.PetAddDto;
import com.app.dto.PetDto;
import com.app.dto.PetResponseDto;
import com.app.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetService petService;

//	@PostMapping("/add-new-pet")
//	public PetResponseDto addNewPet(@RequestBody PetAddDto petAddDto) throws IOException {
//		System.out.println("inside addNewPet");
////		addPet(petAddDto),PetResponseDto.class)
//	 return ;
//		
//	}
	
	
	@PostMapping("add-new-pet")
		public PetResponseDto addNewPet(@RequestBody PetAddDto petAddDto) {
			return petService.addPet(petAddDto);
		}
	
	
//	@PostMapping("addPet")
//	public PetResponseDto addPet(@RequestBody PetDto petDto)
//	{
//		return this.petService.addPet(petDto);
//	}
	
	
	

	@PostMapping("get-single-pet")
	public PetResponseDto getPetDetails(int id) {

		return petService.getPet(id);
	}

	@PostMapping("update-pet-details")
	public ApiResponse updatePet(@RequestBody PetDto petDto) throws IOException {
		return petService.updatePetDetails(petDto);

	}

	@DeleteMapping("delete-pet/{petId}")
	public void deletePet(@PathVariable Integer petId) {
		petService.deletePetById(petId);
	}

	
}
