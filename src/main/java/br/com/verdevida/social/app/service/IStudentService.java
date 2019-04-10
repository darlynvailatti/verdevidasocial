package br.com.verdevida.social.app.service;

import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.pattern.service.IService;
import br.com.verdevida.social.app.processor.dto.AddDocumentToStudent;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService extends IService {

    StudentEntity find(Long id) throws BusinessLogicException;

    List<StudentEntity> listWithPagination(Pageable pagination) throws BusinessLogicException;

    List<StudentEntity> listAll() throws BusinessLogicException;

    void delete(Long id) throws BusinessLogicException;

    StudentEntity confirm(StudentEntity entity) throws BusinessLogicException;

    AddDocumentToStudent.Return addDocumentsToStudent(AddDocumentToStudent add) throws BusinessLogicException;

}
