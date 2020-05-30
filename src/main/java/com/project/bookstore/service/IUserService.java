package com.project.bookstore.service;

import com.project.bookstore.models.User;
import java.util.List;

public interface IUserService {

    List<User> findAllUsers();

    boolean isUserExist(User user);

    void saveUser(User user);

}
