package br.com.verdevida.social.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

@Entity
@Table(name = "student")
public class StudentEntity extends AbstractEntity {

    @Id
    @SequenceGenerator(name = "student_seq_gen", sequenceName = "student_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="student_seq_gen")
    private Long id;

    private String name;
    
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

	@Override
    public String toString() {
        return "StudentEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
