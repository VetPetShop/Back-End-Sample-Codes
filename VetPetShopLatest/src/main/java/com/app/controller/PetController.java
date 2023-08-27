package com.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.PetAddDto;
import com.app.dto.PetResponseDto;
import com.app.service.ImageHandlingService;
import com.app.service.PetService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pets")
@CrossOrigin(origins = "http://localhost:3000")
public class PetController {

	@Autowired
	PetService petService;

	@Autowired
	ImageHandlingService imageService;

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

//	@GetMapping("/get-all-pets-by-city/{cityId}")
//	public ResponseEntity<?> getAllPetsByCityId(@PathVariable int cityId) {
//
//		return new ResponseEntity<>(petService.getPetsByCityId(cityId), HttpStatus.OK);
//
//	}
//	
//	@GetMapping("/get-all-pets-by-postId/{postId}")
//	public ResponseEntity<?> getAllPetsByPostId(@PathVariable int postId) {
//		return new ResponseEntity<>(petService.getAllPetsByPostId(postId), HttpStatus.OK);
//	}

	@PutMapping("/update-pet-details")
	public ResponseEntity<?> updatePet(@RequestBody PetResponseDto petDto) {
		return new ResponseEntity<>(petService.updatePetDetails(petDto), HttpStatus.OK);
	}

	@DeleteMapping("/delete-pet/{petId}")
	public ResponseEntity<HttpStatus> deletePet(@PathVariable int petId) {

		this.petService.deletePetById(petId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping(value = "/{petId}/image", consumes = "multipart/form-data")

	public ResponseEntity<?> uploadImageToServerSideFolder(@RequestParam MultipartFile imageFile,
			@PathVariable Long productId) throws IOException {
		System.out.println("in upload img " + productId + " " + imageFile.getOriginalFilename());
		return new ResponseEntity<>(imageService.uploadImage(productId, imageFile), HttpStatus.CREATED);
	}

	@GetMapping(value = "/{petId}/image", produces = { MediaType.IMAGE_GIF_VALUE, MediaType.IMAGE_JPEG_VALUE,
			MediaType.IMAGE_PNG_VALUE })
	public ResponseEntity<?> serveImageFromServerSideFolder(@PathVariable Long petId) throws IOException {
		System.out.println("in serve img " + petId);
		return new ResponseEntity<>(imageService.serveImage(petId), HttpStatus.OK);
	}

}
