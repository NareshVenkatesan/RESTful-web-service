package com.NV.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.NV.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByemail(String email);

}
