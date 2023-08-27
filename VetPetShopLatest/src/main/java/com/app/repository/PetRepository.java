package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Pet;
import com.app.pojo.User;

public interface PetRepository extends JpaRepository<Pet, Long> {

	Optional<Pet> findById(int id);

//	List<Pet> findAllByCityId(int cityId);
//
//	List<Pet> findAllByPostId(int postId);

}
