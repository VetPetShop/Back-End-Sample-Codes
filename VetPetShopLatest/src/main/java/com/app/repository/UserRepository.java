package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.dto.UserAddDto;
import com.app.pojo.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByEmail(String email);

	User save(UserAddDto userAddDto);

	boolean exitsByEmail(String email);

	//@Query("SELECT COUNT(id) FROM users WHERE id=:wishlistId")
	//int countOfPetsByWishlistId(Long wishlistId);
}
