package hh.swd2.ekaSpringProjekti.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    //List<Student> findByAuthor(String author);
    
}