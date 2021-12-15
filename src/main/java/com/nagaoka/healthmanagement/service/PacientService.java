package com.nagaoka.healthmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagaoka.healthmanagement.dto.PacientDTO;
import com.nagaoka.healthmanagement.mapper.PacientMapper;
import com.nagaoka.healthmanagement.repository.PacientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class PacientService {
	private PacientRepository repository;
	
	private final PacientMapper pacientMapper = PacientMapper.INSTANCE;
	
	public List<PacientDTO> getAll() {
		return this.repository.findAll()
				.stream()
				.map(pacientMapper::toDTO)
				.collect(Collectors.toList());
	}

	public PacientDTO getByCpf(String cpf) {
		// TODO Auto-generated method stub
		return null;
	}
}
