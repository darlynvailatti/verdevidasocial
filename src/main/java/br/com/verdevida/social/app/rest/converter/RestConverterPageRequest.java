package br.com.verdevida.social.app.rest.converter;

import br.com.verdevida.social.app.exception.ArchitectureLogicException;
import br.com.verdevida.social.app.pattern.rest.AbstractRestDTOConverter;
import br.com.verdevida.social.app.rest.dto.PageRequestDTO;
import br.com.verdevida.social.app.rest.dto.SortDTO;
import br.com.verdevida.social.app.util.ExpectThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import javax.annotation.ManagedBean;

@ManagedBean
public class RestConverterPageRequest extends AbstractRestDTOConverter<PageRequestDTO, PageRequest> {

    @Autowired
    private RestConverterSort restConverterSort;

    @Override
    public PageRequestDTO convertToDTO(PageRequest entity) throws ArchitectureLogicException {
        if(ExpectThat.isNull(entity))
            return null;

        SortDTO sortDTO = restConverterSort.convertToDTO(entity.getSort());
        int pageNumber = entity.getPageNumber();
        int pageSize = entity.getPageSize();

        return new PageRequestDTO(pageNumber, pageSize, sortDTO);
    }

    @Override
    public PageRequest convertToEntity(PageRequestDTO dto) throws ArchitectureLogicException {
        if(ExpectThat.isNull(dto))
            return null;
        Sort sortEntity = restConverterSort.convertToEntity(dto.getSort());
        Integer pageSize = dto.getPageSize();
        Integer pageNumber = dto.getPageNumber();

        pageSize = pageSize < 1 ? Integer.MAX_VALUE : pageSize;
        pageNumber = pageNumber < 0 ? 0 : pageNumber;

        return new PageRequest(pageNumber, pageSize, sortEntity);
    }
}
