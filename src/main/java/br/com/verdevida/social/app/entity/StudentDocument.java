package br.com.verdevida.social.app.entity;

import br.com.verdevida.social.app.pattern.repository.AbstractEntity;

import javax.persistence.*;

@Entity
@Table
public class StudentDocument extends AbstractEntity {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    @Override
    public Long getId() {
        return this.id;
    }
}
