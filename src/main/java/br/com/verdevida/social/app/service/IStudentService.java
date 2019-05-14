package br.com.verdevida.social.app.service;

import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.pattern.service.IService;
import br.com.verdevida.social.app.processor.dto.AddDocumentToStudent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentService extends IService {

    StudentEntity find(Long id) throws BusinessLogicException;

    Page<StudentEntity> listWithPagination(Pageable pagination) throws BusinessLogicException;

    public Page<StudentEntity> listByNameContainingWithPagination(@Param("name") String name, Pageable pagination) throws BusinessLogicException;

    List<StudentEntity> listAll() throws BusinessLogicException;

    void delete(Long id) throws BusinessLogicException;

    StudentEntity confirm(StudentEntity entity) throws BusinessLogicException;

    AddDocumentToStudent.Return addDocumentsToStudent(AddDocumentToStudent add) throws BusinessLogicException;

}
