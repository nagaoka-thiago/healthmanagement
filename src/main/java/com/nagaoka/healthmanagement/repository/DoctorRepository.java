package com.nagaoka.healthmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagaoka.healthmanagement.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, String>{

}
