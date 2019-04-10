package br.com.verdevida.social.app.rest.resource;

import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.rest.dto.StudentDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentResource {

    ResponseEntity<StudentDTO> confirm(StudentDTO studentDTO) throws Exception;

    List<StudentDTO> listAll() throws Exception;

    void addDocumentsToStudent() throws Exception;

}
