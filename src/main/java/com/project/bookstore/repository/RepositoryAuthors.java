package com.project.bookstore.repository;

import com.project.bookstore.models.Author;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryAuthors extends CrudRepository<Author, Integer> {

    @Query(value = "SELECT * FROM authors ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Author findRandomAuthor();

    @Query(value = "SELECT * FROM authors\n"
            + "where first_name LIKE '%?1%'", nativeQuery = true)
    List<Author> searchByFirstName(String firstName);

    @Query(value = "SELECT * FROM authors\n"
            + "where last_name LIKE '%?1%'", nativeQuery = true)
    List<Author> searchByLastName(String LastName);
}
