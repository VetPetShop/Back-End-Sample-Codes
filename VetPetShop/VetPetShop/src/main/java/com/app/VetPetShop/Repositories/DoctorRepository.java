package com.app.VetPetShop.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.VetPetShop.Pojos.Doctors;
import com.app.VetPetShop.Pojos.Users;

public interface DoctorRepository extends JpaRepository<Doctors, String> {
	
	Optional<Doctors> findByDoctorId(Users sellerId);

}
