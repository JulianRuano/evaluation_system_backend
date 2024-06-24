package com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.authorization.user.infrastructure.adapters.output.jpaAdapter.Entity.role.RoleEntity;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long>{

}
