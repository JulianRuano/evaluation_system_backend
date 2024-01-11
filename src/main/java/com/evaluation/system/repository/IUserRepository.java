package com.evaluation.system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.models.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username); 

}
