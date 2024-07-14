package com.evaluation.system.form.infrastructure.adapters.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evaluation.system.form.infrastructure.adapters.output.entity.FormEntity;

public interface IFormRepository extends JpaRepository<FormEntity, Long> {
    
}
