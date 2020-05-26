/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookstore.repository;


import com.project.bookstore.models.Publisher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author chatz
 */
public interface RepositoryPublishers extends CrudRepository<Publisher, Integer> {
    
    @Query(value = "SELECT * FROM publishers where name= ?1")
    Publisher findByName(String name);
    
}
