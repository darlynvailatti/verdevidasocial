package br.com.verdevida.social.app.rest.converter;

import javax.annotation.ManagedBean;

import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.exception.ArchitectureLogicException;
import br.com.verdevida.social.app.pattern.rest.AbstractRestDTOConverter;
import br.com.verdevida.social.app.rest.dto.StudentDTO;

@ManagedBean
public class RestConverterStudent extends AbstractRestDTOConverter<StudentDTO, StudentEntity>{

	@Override
	public StudentDTO convertToDTO(StudentEntity entity) throws ArchitectureLogicException {
		return modelMapper.map(entity, StudentDTO.class);
	}

	@Override
	public StudentEntity convertToEntity(StudentDTO dto) throws ArchitectureLogicException {
		return modelMapper.map(dto, StudentEntity.class);
	}

}
