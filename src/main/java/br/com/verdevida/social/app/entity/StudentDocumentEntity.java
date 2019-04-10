package br.com.verdevida.social.app.entity;

import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

import javax.persistence.*;

@Entity
@Table
public class StudentDocumentEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
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
