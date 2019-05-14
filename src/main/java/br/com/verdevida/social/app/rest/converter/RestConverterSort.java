package br.com.verdevida.social.app.rest.converter;

import br.com.verdevida.social.app.exception.ArchitectureLogicException;
import br.com.verdevida.social.app.pattern.rest.AbstractRestDTOConverter;
import br.com.verdevida.social.app.rest.dto.OrderDTO;
import br.com.verdevida.social.app.rest.dto.SortDTO;
import br.com.verdevida.social.app.util.ExpectThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ManagedBean
public class RestConverterSort extends AbstractRestDTOConverter<SortDTO, Sort> {

    @Autowired
    private RestConverterOrder restConverterOrder;

    @Override
    public SortDTO convertToDTO(Sort entity) throws ArchitectureLogicException {
        if(ExpectThat.isNull(entity))
            return null;

        List<OrderDTO> orders = new ArrayList<>();
        Iterator<Sort.Order> iterator = entity.iterator();
        while(iterator.hasNext()){
            Sort.Order order = iterator.next();
            OrderDTO orderDTO = restConverterOrder.convertToDTO(order);
            if(ExpectThat.isNull(orderDTO))
                continue;
            orders.add(orderDTO);
        }

        if(ExpectThat.isNullAndEmpty(orders))
            return null;

        SortDTO dto = new SortDTO(orders);
        return dto;
    }

    @Override
    public Sort convertToEntity(SortDTO dto) throws ArchitectureLogicException {
        if(ExpectThat.isNull(dto))
            return null;

        List<Sort.Order> orders = new ArrayList<>();

        for (OrderDTO orderDTO : dto.getOrders()) {
            Sort.Order orderEntity = restConverterOrder.convertToEntity(orderDTO);
            if(ExpectThat.isNull(orderEntity))
                continue;
            orders.add(orderEntity);
        }

        if(ExpectThat.isNullAndEmpty(orders))
            return null;

        return new Sort(orders);
    }
}
