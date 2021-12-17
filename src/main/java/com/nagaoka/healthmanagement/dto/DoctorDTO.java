package com.nagaoka.healthmanagement.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.nagaoka.healthmanagement.model.Appointment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDTO {
	
	@Size(min = 5, max = 7)
	@NotEmpty
	private String crm;
	
	@Size(min = 2, max = 100)
	@NotEmpty
	private String fullname;
	
	@NotEmpty
	private LocalDate birthday;
	
	@NotEmpty
	@Valid
	private List<Appointment> appointments;
}
