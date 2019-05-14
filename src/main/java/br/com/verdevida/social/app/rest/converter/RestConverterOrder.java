package br.com.verdevida.social.app.rest.converter;

import br.com.verdevida.social.app.exception.ArchitectureLogicException;
import br.com.verdevida.social.app.pattern.rest.AbstractRestDTOConverter;
import br.com.verdevida.social.app.rest.dto.DirectionEnum;
import br.com.verdevida.social.app.rest.dto.OrderDTO;
import br.com.verdevida.social.app.util.ExpectThat;
import org.springframework.data.domain.Sort;

import javax.annotation.ManagedBean;

@ManagedBean
public class RestConverterOrder extends AbstractRestDTOConverter<OrderDTO, Sort.Order> {

    @Override
    public OrderDTO convertToDTO(Sort.Order order) throws ArchitectureLogicException {
        DirectionEnum direction = DirectionEnum.ASC;
        switch (order.getDirection()) {
            case ASC:
                direction = DirectionEnum.ASC;
                break;
            case DESC:
                direction = DirectionEnum.DESC;
        }
        return new OrderDTO(direction, order.getProperty());
    }

    @Override
    public Sort.Order convertToEntity(OrderDTO dto) throws ArchitectureLogicException {
        if(ExpectThat.isNull(dto) || ExpectThat.isNullAndEmpty(dto.getProperty()))
            return null;

        Sort.Direction direction = Sort.Direction.fromString(dto.getDirection().name());
        Sort.Order order = new Sort.Order(direction, dto.getProperty());
        return order;
    }
}
