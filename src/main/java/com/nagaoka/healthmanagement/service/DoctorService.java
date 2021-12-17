package com.nagaoka.healthmanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagaoka.healthmanagement.dto.DoctorDTO;
import com.nagaoka.healthmanagement.dto.MessageDTO;
import com.nagaoka.healthmanagement.exception.DoctorNotFoundException;
import com.nagaoka.healthmanagement.mapper.DoctorMapper;
import com.nagaoka.healthmanagement.model.Doctor;
import com.nagaoka.healthmanagement.repository.DoctorRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class DoctorService {
	
	private DoctorRepository repository;
	
	private final DoctorMapper doctorMapper = DoctorMapper.INSTANCE;
	
	public List<DoctorDTO> getAll() {
		return this.repository.findAll().stream()
										.map(doctorMapper::toDTO)
										.collect(Collectors.toList());
	}
	
	public DoctorDTO getByCRM(String crm) throws DoctorNotFoundException{
		Doctor doctor = verifyExistsDoctor(crm);
		return doctorMapper.toDTO(doctor);
	}
	
	public MessageDTO createDoctor(DoctorDTO doctor) {
		Doctor newDoctor = doctorMapper.toModel(doctor);
		this.repository.save(newDoctor);
		return getMessage("Doctor with CRM " + doctor.getCrm() + " is registered in our database.");
	}
	
	public MessageDTO updateDoctor(String crm, DoctorDTO doctor) throws DoctorNotFoundException{
		verifyExistsDoctor(crm);
		Doctor newDoctor = doctorMapper.toModel(doctor);
		this.repository.save(newDoctor);
		return getMessage("Update in doctor with CRM " + doctor.getCrm() + " is registered in our database.");
	}
	
	public void deleteDoctor(String crm) throws DoctorNotFoundException {
		Doctor doctor = verifyExistsDoctor(crm);
		this.repository.delete(doctor);
	}
	
	private Doctor verifyExistsDoctor(String crm) throws DoctorNotFoundException{
		return this.repository.findById(crm).orElseThrow(() -> new DoctorNotFoundException(crm));
	}
	
	private MessageDTO getMessage(String message) {
		return MessageDTO.builder()
					.message(message)
				 .build();
}
}
