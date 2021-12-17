package com.nagaoka.healthmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagaoka.healthmanagement.dto.DoctorDTO;
import com.nagaoka.healthmanagement.dto.MessageDTO;
import com.nagaoka.healthmanagement.exception.DoctorNotFoundException;
import com.nagaoka.healthmanagement.service.DoctorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/doctors")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class DoctorController {
	
	private DoctorService service;
	
	@GetMapping
	public List<DoctorDTO> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{crm}")
	public DoctorDTO getByCRM(@PathVariable("crm") String crm) throws DoctorNotFoundException{
		return this.service.getByCRM(crm);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageDTO createDoctor(@RequestBody DoctorDTO doctor) {
		return this.service.createDoctor(doctor);
	}
	
	@PutMapping("/{crm}")
	public MessageDTO updateDoctor(@PathVariable("crm") String crm, @RequestBody DoctorDTO doctor) throws DoctorNotFoundException{
		return this.service.updateDoctor(crm, doctor);
	}
	
	@DeleteMapping("/{crm}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteDoctor(@PathVariable("crm") String crm) throws DoctorNotFoundException{
		this.service.deleteDoctor(crm);
	}
}
