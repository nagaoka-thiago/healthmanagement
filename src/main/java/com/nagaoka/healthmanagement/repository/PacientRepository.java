package com.nagaoka.healthmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagaoka.healthmanagement.model.Pacient;

public interface PacientRepository extends JpaRepository<Pacient, String>{

}
