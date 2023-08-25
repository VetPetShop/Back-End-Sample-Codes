package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.PetAddDto;
import com.app.dto.PetResponseDto;
import com.app.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {

	@Autowired
	private PetService petService;

	@PostMapping("/add-pet")
	public ResponseEntity<?> addPet(@RequestBody PetAddDto petAddDto) {
		return new ResponseEntity<>(petService.addPet(petAddDto), HttpStatus.OK);

	}

	@GetMapping("/get-Single-Pet/{petId}")

	public ResponseEntity<?> getSinglePet(@PathVariable int petId) {
		return new ResponseEntity<>(petService.getPet(petId), HttpStatus.OK);
	}

	@GetMapping("/get-all-pets")
	public ResponseEntity<?> getAllPets() {
		return new ResponseEntity<>(petService.getAllPets(), HttpStatus.OK);
	}

	@GetMapping("/get-all-pets-by-city/{cityId}")
	public ResponseEntity<?> getAllPetsByCityId(@PathVariable int cityId) {

		return new ResponseEntity<>(petService.getPetsByCityId(cityId), HttpStatus.OK);

	}

	@GetMapping("/get-all-pets-by-postId/{postId}")
	public ResponseEntity<?> getAllPetsByPostId(@PathVariable int postId) {
		return new ResponseEntity<>(petService.getAllPetsByPostId(postId), HttpStatus.OK);
	}

	@PutMapping("/update-pet-details")
	public ResponseEntity<?> updatePet(@RequestBody PetResponseDto petDto) {
		return new ResponseEntity<>(petService.updatePetDetails(petDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete-pet/{petId}")
	public ResponseEntity<HttpStatus> deletePet(@PathVariable int petId) {

		this.petService.deletePetById(petId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
