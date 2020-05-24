package com.project.bookstore.repository;

import com.project.bookstore.models.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryAuthors extends CrudRepository<Author, Integer> {

    @Query(value = "SELECT * FROM authors ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Author findRandomAuthor();

}
