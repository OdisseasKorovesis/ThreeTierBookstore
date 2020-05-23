/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookstore.repository;

import com.project.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author chatz
 */
public interface RepositoryBooks extends CrudRepository<Book, Integer>  {
    Book findBookById(Integer id);
}
