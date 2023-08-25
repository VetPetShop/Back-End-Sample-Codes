package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.Pet;

public interface PetRepository extends JpaRepository<Pet, Integer> {

}
