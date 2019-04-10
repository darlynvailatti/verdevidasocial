package br.com.verdevida.social.app.rest.resource.impl;

import br.com.verdevida.social.app.App;
import br.com.verdevida.social.app.VerdeVidaContext;
import br.com.verdevida.social.app.entity.StudentDocument;
import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.processor.dto.AddDocumentToStudent;
import br.com.verdevida.social.app.rest.dto.StudentDTO;
import br.com.verdevida.social.app.rest.resource.IStudentResource;
import br.com.verdevida.social.app.service.IStudentService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentResourceImpl implements IStudentResource {

    private static final Logger log = LoggerFactory.getLogger(StudentResourceImpl.class);

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    @PostMapping
    public ResponseEntity<StudentDTO> confirm(@RequestBody StudentDTO studentDTO) throws Exception{
        StudentEntity entity = convertToEntity(studentDTO);
        log.info("Entity: {}", entity);
        StudentEntity createdStudent = studentService.confirm(entity);
        studentDTO = convertToDTO(createdStudent);
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

    @Override
    @GetMapping
    public @ResponseBody List<StudentDTO> listAll() throws BusinessLogicException{
        List<StudentEntity> studentEntities = studentService.listAll();
        List<StudentDTO> studentsDTO = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
            StudentDTO studentDTO = convertToDTO(studentEntity);
            studentsDTO.add(studentDTO);
        }
        return studentsDTO;
    }

    @Override
    @PostMapping("/documents")
    public void addDocumentsToStudent() throws Exception {
        VerdeVidaContext context = new VerdeVidaContext();
        List<StudentDocument> documents = new ArrayList<>();
        StudentEntity student = new StudentEntity();
        AddDocumentToStudent add = new AddDocumentToStudent(context, student, documents);
        studentService.addDocumentsToStudent(add);
    }

    private StudentEntity convertToEntity(StudentDTO dto){
        StudentEntity map = modelMapper.map(dto, StudentEntity.class);
        return map;
    }

    private StudentDTO convertToDTO(StudentEntity entity){
        StudentDTO map = modelMapper.map(entity, StudentDTO.class);
        return map;
    }
}
