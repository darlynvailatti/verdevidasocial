package br.com.verdevida.social.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.verdevida.social.app.entity.StudentDocumentEntity;

@Repository
public interface IStudentDocumentoRepository extends PagingAndSortingRepository<StudentDocumentEntity, Long>{

}
