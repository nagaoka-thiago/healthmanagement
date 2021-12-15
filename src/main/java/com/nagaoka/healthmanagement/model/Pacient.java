package com.nagaoka.healthmanagement.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class Pacient {
	@Id
	private String cpf;
	
	@Column(nullable = false)
	private String fullname;
	
	@Column(nullable = false)
	private LocalDate birthday;
}
