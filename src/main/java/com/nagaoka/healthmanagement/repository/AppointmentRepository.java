package com.nagaoka.healthmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagaoka.healthmanagement.embeddedid.AppointmentId;
import com.nagaoka.healthmanagement.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId>{

}
