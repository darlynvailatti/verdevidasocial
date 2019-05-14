package br.com.verdevida.social.app.repository;

import br.com.verdevida.social.app.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DefaultData {

    @Autowired
    private IStudentRepository studentRepository;

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        StudentEntity student1 = new StudentEntity();
        student1.setName("Fulano");
        student1.setBirthDate(LocalDate.of(1999,1,20));
        student1.setRegisterDate(LocalDate.now());

        StudentEntity student2 = new StudentEntity();
        student2.setName("Beltrano");
        student2.setBirthDate(LocalDate.of(2001,1,26));
        student2.setRegisterDate(LocalDate.now());

        StudentEntity student3 = new StudentEntity();
        student3.setName("Ciclano");
        student3.setBirthDate(LocalDate.of(2002,4,20));
        student3.setRegisterDate(LocalDate.now());

        StudentEntity student4 = new StudentEntity();
        student4.setName("Joao");
        student4.setBirthDate(LocalDate.of(2001,6,20));
        student4.setRegisterDate(LocalDate.now());

        StudentEntity student5 = new StudentEntity();
        student5.setName("Maria");
        student5.setBirthDate(LocalDate.of(1998,2,20));
        student5.setRegisterDate(LocalDate.now());

        StudentEntity student6 = new StudentEntity();
        student6.setName("Jose");
        student6.setBirthDate(LocalDate.of(1994,1,20));
        student6.setRegisterDate(LocalDate.now());

        StudentEntity student7 = new StudentEntity();
        student7.setName("Gandalf");
        student7.setBirthDate(LocalDate.of(1999,1,20));
        student7.setRegisterDate(LocalDate.now());

        StudentEntity student8 = new StudentEntity();
        student8.setName("Sauron");
        student8.setBirthDate(LocalDate.of(2005,4,21));
        student8.setRegisterDate(LocalDate.now());

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);
        studentRepository.save(student5);
        studentRepository.save(student6);
        studentRepository.save(student7);
        studentRepository.save(student8);

    }
}
