package br.com.verdevida.social.app.entity;

import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table
public class StudentEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String name;
    
    @OneToMany(fetch = FetchType.LAZY)
    private Set<StudentDocumentEntity> documents;

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public Set<StudentDocumentEntity> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<StudentDocumentEntity> documents) {
		this.documents = documents;
	}

	@Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
