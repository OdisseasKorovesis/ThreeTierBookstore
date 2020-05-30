package com.project.bookstore.repository;

import com.project.bookstore.models.Author;
import com.project.bookstore.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryUsers extends CrudRepository<User, Integer> {

    User findUserById(Integer id);

    @Query(value = "SELECT * FROM users\n"
            + "WHERE first_name = ?1", nativeQuery = true)
    Author findByFirstName(String firstName);

    @Query(value = "SELECT * FROM users\n"
            + "WHERE last_name= ?1", nativeQuery = true)
    Author findByLastName(String lastName);

}
