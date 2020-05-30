package com.project.bookstore.controller;

import com.project.bookstore.models.User;
import com.project.bookstore.service.UserServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tier3")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    /**
     * GET /users : Get all users
     *
     * @return the ResponseEntity with status 200 (OK) and the list of users in
     * the body, or with status 204 (NO CONTENT) if there are no users in the
     * database.
     */
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}
