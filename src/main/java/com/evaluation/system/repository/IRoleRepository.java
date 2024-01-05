package com.evaluation.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.models.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

}
