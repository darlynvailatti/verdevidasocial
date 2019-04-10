package br.com.verdevida.social.app.rest.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.verdevida.social.app.rest.dto.StudentDTO;
import br.com.verdevida.social.app.rest.dto.StudentDocumentDTO;

public interface IStudentResource {

    ResponseEntity<StudentDTO> confirm(StudentDTO studentDTO) throws Exception;

    List<StudentDTO> listAll() throws Exception;

    List<StudentDocumentDTO> addDocumentsToStudent(Long idStudent, List<StudentDocumentDTO> documents) throws Exception;

}
