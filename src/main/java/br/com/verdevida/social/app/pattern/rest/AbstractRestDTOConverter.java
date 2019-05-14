package br.com.verdevida.social.app.pattern.rest;

import javax.annotation.ManagedBean;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

@ManagedBean
public abstract class AbstractRestDTOConverter<DTO extends AbstractRestDTO, Entity> implements IRestDTOConverter<DTO, Entity>{

	@Autowired
	protected ModelMapper modelMapper;
	
}
