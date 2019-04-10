package br.com.verdevida.social.app.processor;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.verdevida.social.app.entity.StudentDocumentEntity;
import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.pattern.processor.AbstractProcessor;
import br.com.verdevida.social.app.processor.dto.AddDocumentToStudent;
import br.com.verdevida.social.app.repository.IStudentDocumentoRepository;

@ManagedBean
public class ProcessorAddDocumentToStudent
    extends AbstractProcessor<AddDocumentToStudent, AddDocumentToStudent.Return> {

    private static final Logger log = LoggerFactory.getLogger(ProcessorAddDocumentToStudent.class);
    
    @Autowired
    private IStudentDocumentoRepository studentDocumentRepository;

    private List<StudentDocumentEntity> savedDocuments;
    
    @Override
    protected void executionImplementation() throws BusinessLogicException {
    	
    	savedDocuments = new ArrayList<>();
    	
    	StudentEntity student = input.getStudent();
    	for (StudentDocumentEntity studentDocumentEntity : input.getDocuments()) {
    		studentDocumentEntity.setStudent(student);
			log.info("Document: {}", studentDocumentEntity);
			studentDocumentRepository.save(studentDocumentEntity);
			savedDocuments.add(studentDocumentEntity);
		}
    }

    @Override
    protected void executionReturn() {
        output = new AddDocumentToStudent.Return(savedDocuments);
    }

    @Override
    protected String getName() {
        return ProcessorAddDocumentToStudent.class.getSimpleName();
    }
}
