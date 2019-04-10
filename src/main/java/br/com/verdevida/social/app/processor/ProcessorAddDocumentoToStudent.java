package br.com.verdevida.social.app.processor;

import br.com.verdevida.social.app.entity.StudentDocument;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.pattern.processor.AbstractProcessor;
import br.com.verdevida.social.app.processor.dto.AddDocumentToStudent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ProcessorAddDocumentoToStudent
    extends AbstractProcessor<AddDocumentToStudent, AddDocumentToStudent.Return> {

    private static final Logger log = LoggerFactory.getLogger(ProcessorAddDocumentoToStudent.class);

    @Override
    protected void executionImplementation() throws BusinessLogicException {
        log.info("Executando {} ", getName());
    }

    @Override
    protected void executionReturn() {
        List<StudentDocument> studentDocuments = new ArrayList<>();
        output = new AddDocumentToStudent.Return(studentDocuments);
    }

    @Override
    protected String getName() {
        return ProcessorAddDocumentoToStudent.class.getSimpleName();
    }
}
