package com.evaluation.system.user.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.user.domain.models.role.Role;

public interface IRoleRepository extends JpaRepository<Role, Long>{

}
