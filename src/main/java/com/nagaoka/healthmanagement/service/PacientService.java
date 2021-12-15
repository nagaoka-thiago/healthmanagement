package com.nagaoka.healthmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagaoka.healthmanagement.dto.MessageDTO;
import com.nagaoka.healthmanagement.dto.PacientDTO;
import com.nagaoka.healthmanagement.exception.PacientNotFoundException;
import com.nagaoka.healthmanagement.mapper.PacientMapper;
import com.nagaoka.healthmanagement.model.Pacient;
import com.nagaoka.healthmanagement.repository.PacientRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class PacientService {
	private PacientRepository repository;
	
	//private final PacientMapper pm = PacientMapper.INSTANCE;
	
	public List<PacientDTO> getAll() {
		return this.repository.findAll()
				.stream()
				.map(pacient -> toDTO(pacient))
				.collect(Collectors.toList());
	}

	public PacientDTO getByCpf(String cpf) throws PacientNotFoundException{
		Pacient pacient = verifyExistsPacient(cpf);
		return toDTO(pacient);
	}
	
	public MessageDTO createPacient(PacientDTO pacient) {
		Pacient newPacient = toModel(pacient);
		this.repository.save(newPacient);
		return getMessage("Pacient with CPF " + pacient.getCpf() + " is registered in our database.");
	}
	
	public MessageDTO updatePacient(String cpf, PacientDTO pacient) throws PacientNotFoundException{
		verifyExistsPacient(cpf);
		Pacient newPacient = toModel(pacient);
		this.repository.save(newPacient);
		return getMessage("Update in pacient with CPF " + pacient.getCpf() + " is registered in our database.");
	}
	
	public void deletePacient(String cpf) throws PacientNotFoundException {
		Pacient pacient = verifyExistsPacient(cpf);
		this.repository.delete(pacient);
	}
	
	private PacientDTO toDTO(Pacient pacient) {
		return PacientDTO.builder()
				.birthday(pacient.getBirthday())
				.cpf(pacient.getCpf())
				.fullname(pacient.getFullname())
			  .build();
	}
	
	private Pacient verifyExistsPacient(String cpf) throws PacientNotFoundException{
		return this.repository.findById(cpf).orElseThrow(() -> new PacientNotFoundException(cpf));
	}
	
	private Pacient toModel(PacientDTO pacientDTO) {
		return Pacient.builder()
				.birthday(pacientDTO.getBirthday())
				.cpf(pacientDTO.getCpf())
				.fullname(pacientDTO.getFullname())
			  .build();
	}
	
	private MessageDTO getMessage(String message) {
			return MessageDTO.builder()
						.message(message)
					 .build();
	}
}
