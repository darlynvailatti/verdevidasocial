package br.com.verdevida.social.app.pattern.rest;

import br.com.verdevida.social.app.exception.ArchitectureLogicException;
import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

public interface IRestDTOConverter<DTO extends AbstractRestDTO,Entity extends AbstractEntity> {

	DTO convertToDTO(Entity entity) throws ArchitectureLogicException;

	Entity convertToEntity(DTO dto) throws ArchitectureLogicException;
	
}
