package com.project.bookstore.repository;

import com.project.bookstore.models.User;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryUsers extends CrudRepository<User, Integer> {

    User findUserById(Integer id);

}
