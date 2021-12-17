package com.nagaoka.healthmanagement.embeddedid;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.nagaoka.healthmanagement.model.Doctor;
import com.nagaoka.healthmanagement.model.Pacient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentId implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(targetEntity = Pacient.class)
	@JoinColumn(name = "cpf")
	private String cpf;
	
	@ManyToOne(targetEntity = Doctor.class)
	@JoinColumn(name = "crm")
	private String crm;
	
	private LocalDate appointment_date;
}
