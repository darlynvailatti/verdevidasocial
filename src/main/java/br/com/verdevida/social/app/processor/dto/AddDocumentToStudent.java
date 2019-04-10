package br.com.verdevida.social.app.processor.dto;

import br.com.verdevida.social.app.VerdeVidaContext;
import br.com.verdevida.social.app.entity.StudentDocument;
import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.pattern.processor.AbstractProcessorDTO;

import java.util.List;

public class AddDocumentToStudent extends AbstractProcessorDTO {

    private VerdeVidaContext context;

    private StudentEntity student;

    private List<StudentDocument> documents;

    public AddDocumentToStudent(VerdeVidaContext context, StudentEntity student, List<StudentDocument> documents) {
        this.context = context;
        this.student = student;
        this.documents = documents;
    }

    public VerdeVidaContext getContext() {
        return context;
    }

    public void setContext(VerdeVidaContext context) {
        this.context = context;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public List<StudentDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<StudentDocument> documents) {
        this.documents = documents;
    }


    public static class Return extends AbstractProcessorDTO {

        private List<StudentDocument> documents;

        public Return(List<StudentDocument> documents) {
            this.documents = documents;
        }

        public List<StudentDocument> getDocuments() {
            return documents;
        }

        public void setDocuments(List<StudentDocument> documents) {
            this.documents = documents;
        }
    }
}
