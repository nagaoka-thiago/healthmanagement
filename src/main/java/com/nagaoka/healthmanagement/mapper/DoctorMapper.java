package com.nagaoka.healthmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.nagaoka.healthmanagement.dto.DoctorDTO;
import com.nagaoka.healthmanagement.model.Doctor;

@Mapper
public interface DoctorMapper {
	DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);
	
	Doctor toModel(DoctorDTO doctorDTO);
	DoctorDTO toDTO(Doctor doctor);
}
