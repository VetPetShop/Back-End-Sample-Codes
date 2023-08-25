package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojo.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	

//	User findByEmail(String email);
//	@Modifying
//	@Query("SELECT COUNT(u) > 0 FROM User u WHERE u.email = :email")
//    boolean existsByEmail(@Param("email") String email);
	
	Optional<User> findByEmailAndPassword(String email, String password);

	User findByEmail(String email);

	boolean existsByEmail(String email);
}
