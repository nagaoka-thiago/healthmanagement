package com.nagaoka.healthmanagement.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.nagaoka.healthmanagement.model.Appointment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PacientDTO {
	
	@NotEmpty
	@CPF
	private String cpf;
	
	@NotEmpty
	@Size(min = 2, max = 100)
	private String fullname;

	@NotEmpty
	private LocalDate birthday;
	
	@NotEmpty
	@Valid
	private List<Appointment> appointments;
}
