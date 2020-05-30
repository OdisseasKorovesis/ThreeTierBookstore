package com.project.bookstore.service;

import com.project.bookstore.models.User;
import com.project.bookstore.repository.RepositoryUsers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private RepositoryUsers repositoryUsers;

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        repositoryUsers.findAll()
                .forEach(users::add);
        return users;
    }

}
