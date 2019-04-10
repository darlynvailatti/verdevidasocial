package br.com.verdevida.social.app.rest.converter;

import javax.annotation.ManagedBean;

import br.com.verdevida.social.app.entity.StudentDocumentEntity;
import br.com.verdevida.social.app.exception.ArchitectureLogicException;
import br.com.verdevida.social.app.pattern.rest.AbstractRestDTOConverter;
import br.com.verdevida.social.app.rest.dto.StudentDocumentDTO;

@ManagedBean
public class RestConverterStudentDocument extends AbstractRestDTOConverter<StudentDocumentDTO, StudentDocumentEntity>{

	@Override
	public StudentDocumentDTO convertToDTO(StudentDocumentEntity entity) throws ArchitectureLogicException {
		return modelMapper.map(entity, StudentDocumentDTO.class);
	}

	@Override
	public StudentDocumentEntity convertToEntity(StudentDocumentDTO dto) throws ArchitectureLogicException {
		return modelMapper.map(dto, StudentDocumentEntity.class);
	}

}
