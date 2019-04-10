package br.com.verdevida.social.app.entity;

import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

import javax.persistence.*;

@Entity
@Table
public class StudentEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
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
