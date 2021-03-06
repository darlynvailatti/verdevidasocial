package br.com.verdevida.social.app.rest.resource.impl;

import java.util.ArrayList;
import java.util.List;

import br.com.verdevida.social.app.rest.converter.RestConverterPageRequest;
import br.com.verdevida.social.app.rest.dto.PageDTO;
import br.com.verdevida.social.app.rest.dto.PageRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.verdevida.social.app.entity.StudentDocumentEntity;
import br.com.verdevida.social.app.entity.StudentEntity;
import br.com.verdevida.social.app.exception.BusinessLogicException;
import br.com.verdevida.social.app.pattern.rest.AbstractRestResource;
import br.com.verdevida.social.app.processor.dto.AddDocumentToStudent;
import br.com.verdevida.social.app.rest.converter.RestConverterStudent;
import br.com.verdevida.social.app.rest.converter.RestConverterStudentDocument;
import br.com.verdevida.social.app.rest.dto.StudentDTO;
import br.com.verdevida.social.app.rest.dto.StudentDocumentDTO;
import br.com.verdevida.social.app.rest.resource.IStudentResource;
import br.com.verdevida.social.app.service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentResourceImpl extends AbstractRestResource
	implements IStudentResource {

    private static final Logger log = LoggerFactory.getLogger(StudentResourceImpl.class);

    @Autowired
    private IStudentService studentService;
    
    @Autowired
    private RestConverterStudent restConverterStudent;

    @Autowired
    private RestConverterPageRequest restConverterPageRequest;
    
    @Autowired
    private RestConverterStudentDocument restConverterStudentDocument;

    @Override
    @PostMapping
    public ResponseEntity<StudentDTO> confirm(@RequestBody StudentDTO studentDTO) throws Exception{
        StudentEntity entity = restConverterStudent.convertToEntity(studentDTO);
        StudentEntity createdStudent = studentService.confirm(entity);
        studentDTO = restConverterStudent.convertToDTO(createdStudent);
        return new ResponseEntity<>(studentDTO, HttpStatus.CREATED);
    }

    @Override
    @PostMapping("all/by/pagination")
    public @ResponseBody PageDTO<StudentDTO> listAllWithPagination(@RequestBody PageRequestDTO pageRequestDTO) throws Exception{
        PageRequest pageRequest = restConverterPageRequest.convertToEntity(pageRequestDTO);
        Page<StudentEntity> page = studentService.listWithPagination(pageRequest);
        List<StudentDTO> studentsDTO = new ArrayList<>();

        for (StudentEntity studentEntity : page.getContent()) {
            StudentDTO studentDTO = restConverterStudent.convertToDTO(studentEntity);
            studentsDTO.add(studentDTO);
        }

        return new PageDTO<>(page.getTotalElements(), studentsDTO);
    }

    @Override
    @PostMapping("/by/name/pagination")
    public @ResponseBody PageDTO<StudentDTO> listAllByNameContainingWithPagination(@RequestParam String name, @RequestBody PageRequestDTO pageRequestDTO) throws Exception{
        System.out.println("Name search for:" + name);
        PageRequest pageRequest = restConverterPageRequest.convertToEntity(pageRequestDTO);
        Page<StudentEntity> page = studentService.listByNameContainingWithPagination(name,pageRequest);
        List<StudentDTO> studentsDTO = new ArrayList<>();

        for (StudentEntity studentEntity : page.getContent()) {
            StudentDTO studentDTO = restConverterStudent.convertToDTO(studentEntity);
            studentsDTO.add(studentDTO);
        }

        return new PageDTO<>(page.getTotalElements(), studentsDTO);
    }

    @Override
    @GetMapping
    public @ResponseBody List<StudentDTO> listAll() throws BusinessLogicException{
        List<StudentEntity> studentEntities = studentService.listAll();
        List<StudentDTO> studentsDTO = new ArrayList<>();
        for (StudentEntity studentEntity : studentEntities) {
        	try {
        		StudentDTO studentDTO = restConverterStudent.convertToDTO(studentEntity);
        		studentsDTO.add(studentDTO);
			} catch (Exception e) {
				throw new BusinessLogicException(e);
			}
        }
        return studentsDTO;
    }
    
    @GetMapping("{idStudent}")
    public ResponseEntity<StudentDTO> get(@PathVariable("idStudent") Long idStudent) throws Exception {
    	StudentEntity student = studentService.find(idStudent);
    	StudentDTO dto = restConverterStudent.convertToDTO(student);
    	return new ResponseEntity<>(dto, HttpStatus.FOUND);
    }
    
    @Override
    @PostMapping("{idStudent}/documents")
    public List<StudentDocumentDTO> addDocumentsToStudent(@PathVariable("idStudent") Long idStudent, 
    		@RequestBody List<StudentDocumentDTO> documents) throws Exception {
    	
    	log.info("Student ID: {}", idStudent);
    	List<StudentDocumentEntity> studentDocumentEntities = new ArrayList<>();
    	for (StudentDocumentDTO studentDocumentDTO : documents) {
			StudentDocumentEntity studentDocument = restConverterStudentDocument.convertToEntity(studentDocumentDTO);
			studentDocumentEntities.add(studentDocument);
		}
    	
    	StudentEntity studentEntity = studentService.find(idStudent);
    	log.info("Student Founded: {}", studentEntity);
    	
        AddDocumentToStudent add = new AddDocumentToStudent(getContext(), studentEntity, studentDocumentEntities);
        List<StudentDocumentEntity> savedDocuments = studentService.addDocumentsToStudent(add).getDocuments();
        
        List<StudentDocumentDTO> savedDocumentsDTO = new ArrayList<>();
        
        for (StudentDocumentEntity savedDocument : savedDocuments) {
        	StudentDocumentDTO dto = restConverterStudentDocument.convertToDTO(savedDocument);
			savedDocumentsDTO.add(dto);
		}
        return savedDocumentsDTO;
    }

}
