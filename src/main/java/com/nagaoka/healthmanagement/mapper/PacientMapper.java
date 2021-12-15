package com.nagaoka.healthmanagement.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.nagaoka.healthmanagement.dto.PacientDTO;
import com.nagaoka.healthmanagement.model.Pacient;

@Mapper
public interface PacientMapper {
	
	PacientMapper INSTANCE = Mappers.getMapper(PacientMapper.class);
	
	@Mapping(source = "birthday", target = "birthday", dateFormat = "dd/MM/yyyy")
	Pacient toModel(PacientDTO pacientDTO);
	PacientDTO toDTO(Pacient pacient);
}
