package br.com.verdevida.social.app.rest.dto;

import br.com.verdevida.social.app.pattern.rest.AbstractRestDTO;

import java.util.List;

public class SortDTO extends AbstractRestDTO {

    private List<OrderDTO> orders;

    public SortDTO() {
    }

    public SortDTO(List<OrderDTO> orders) {
        this.orders = orders;
    }

    public List<OrderDTO> getOrders() {
        return orders;
    }

    public void setOrders(List<OrderDTO> orders) {
        this.orders = orders;
    }
}
