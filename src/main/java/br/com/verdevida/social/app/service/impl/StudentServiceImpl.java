package br.com.verdevida.social.app.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.processor.ProcessorAddDocumentToStudent;
import br.com.verdevida.social.app.processor.dto.AddDocumentToStudent;
import br.com.verdevida.social.app.repository.IStudentRepository;
import br.com.verdevida.social.app.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ProcessorAddDocumentToStudent processorAddDocumentoToStudent;

    @Override
    public StudentEntity find(Long id) throws BusinessLogicException {
        return studentRepository.findOne(id);
    }

    @Override
    public List<StudentEntity> listWithPagination(Pageable pagination) throws BusinessLogicException {
        return null;
    }

    @Override
    public List<StudentEntity> listAll() throws BusinessLogicException {
        Spliterator<StudentEntity> spliterator = studentRepository.findAll().spliterator();
        List<StudentEntity> students = new ArrayList<>();
        spliterator.forEachRemaining(students::add);
        return students;
    }

    @Override
    public void delete(Long id) throws BusinessLogicException {
        studentRepository.delete(id);
    }

    @Override
    public StudentEntity confirm(StudentEntity entity) throws BusinessLogicException {
        return studentRepository.save(entity);
    }

    @Override
    public AddDocumentToStudent.Return addDocumentsToStudent(AddDocumentToStudent add) throws BusinessLogicException {
        return processorAddDocumentoToStudent.execute(add);
    }


}
