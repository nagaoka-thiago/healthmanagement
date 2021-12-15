package com.nagaoka.healthmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagaoka.healthmanagement.dto.PacientDTO;
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
	public PacientDTO getById(@PathVariable("cpf") String cpf) {
		return this.service.getByCpf(cpf);
	}

}
