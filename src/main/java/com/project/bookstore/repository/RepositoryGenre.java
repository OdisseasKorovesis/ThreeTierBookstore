package com.project.bookstore.repository;

import com.project.bookstore.models.Genre;
import com.project.bookstore.models.Language;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryGenre extends CrudRepository<Genre, Integer> {

    @Query(value = "SELECT * FROM genre WHERE name= ?1", nativeQuery = true)
    Language findByName(String name);

}
