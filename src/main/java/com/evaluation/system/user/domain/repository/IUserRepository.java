package com.evaluation.system.user.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.user.domain.models.user.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByUsername(String username); 

}
