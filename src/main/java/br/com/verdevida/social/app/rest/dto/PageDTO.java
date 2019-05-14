package br.com.verdevida.social.app.rest.dto;

import java.util.List;

public class PageDTO<T> {

    private Long totalElements;

    private List<T> elements;

    public PageDTO() {
    }

    public PageDTO(Long totalElements, List<T> elements) {
        this.totalElements = totalElements;
        this.elements = elements;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }

    public List<T> getElements() {
        return elements;
    }

    public void setElements(List<T> elements) {
        this.elements = elements;
    }
}
