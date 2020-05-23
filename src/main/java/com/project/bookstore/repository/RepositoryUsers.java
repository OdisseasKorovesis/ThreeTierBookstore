/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.bookstore.repository;

import com.project.bookstore.models.User;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author chatz
 */
public interface RepositoryUsers extends CrudRepository<User, Integer>  {
    
   User findUserById(Integer id);
    
}


    
   
    

