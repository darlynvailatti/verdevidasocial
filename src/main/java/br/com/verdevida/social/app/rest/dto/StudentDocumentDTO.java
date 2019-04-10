package br.com.verdevida.social.app.rest.dto;

import br.com.verdevida.social.app.pattern.rest.AbstractRestDTO;

public class StudentDocumentDTO extends AbstractRestDTO{

	private Long id;
	
	private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
