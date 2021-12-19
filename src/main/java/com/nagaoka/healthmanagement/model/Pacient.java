package com.nagaoka.healthmanagement.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "pacients")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "cpf", scope = Pacient.class)
public class Pacient {
	@Id
	private String cpf;
	
	@Column(nullable = false)
	private String fullname;
	
	@Column(nullable = false)
	private LocalDate birthday;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "cpf")
	private List<Appointment> appointments;
}
