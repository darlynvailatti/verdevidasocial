package br.com.verdevida.social.app.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

@Entity
@Table(name="student_document")
public class StudentDocumentEntity extends AbstractEntity {

	 @Id
    @SequenceGenerator(name = "student_document_seq_gen", sequenceName = "student_document_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="student_document_seq_gen")
    private Long id;
    
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private StudentEntity student;

    @Override
    public Long getId() {
        return this.id;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentDocumentEntity [id=" + id + ", description=" + description + ", student=" + student + "]";
	}
	
}
