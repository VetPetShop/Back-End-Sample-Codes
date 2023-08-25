package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Pet;
import com.app.pojo.User;

public interface PetRepository extends JpaRepository<Pet, Integer> {

	List<Pet> findAllByCityId(int cityId);

	List<Pet> findAllByPostId(int postId);

	Optional<User> findByUserIdAndPetId(int userId, int petId);

}
