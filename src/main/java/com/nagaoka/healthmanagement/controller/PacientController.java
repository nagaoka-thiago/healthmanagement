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

import com.nagaoka.healthmanagement.dto.MessageDTO;
import com.nagaoka.healthmanagement.dto.PacientDTO;
import com.nagaoka.healthmanagement.exception.PacientNotFoundException;
import com.nagaoka.healthmanagement.service.PacientService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/pacients")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class PacientController {
	private PacientService service;
	
	@GetMapping
	public List<PacientDTO> getAll() {
		return this.service.getAll();
	}
	
	@GetMapping("/{cpf}")
	public PacientDTO getById(@PathVariable("cpf") String cpf) throws PacientNotFoundException {
		return this.service.getByCpf(cpf);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageDTO createPacient(@RequestBody PacientDTO pacient) {
		return this.service.createPacient(pacient);
	}
	
	@PutMapping("/{cpf}")
	public MessageDTO updatePacient(@PathVariable("cpf") String cpf, @RequestBody PacientDTO pacient) throws PacientNotFoundException {
		return this.service.updatePacient(cpf, pacient);
	}
	
	@DeleteMapping("/{cpf}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePacient(@PathVariable("cpf") String cpf) throws PacientNotFoundException{
		this.service.deletePacient(cpf);
	}
}