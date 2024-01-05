package com.evaluation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.models.User;

public interface IUserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}
