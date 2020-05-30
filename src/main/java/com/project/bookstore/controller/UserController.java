package com.project.bookstore.controller;

import com.project.bookstore.models.Book;
import com.project.bookstore.models.User;
import com.project.bookstore.service.UserServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    /**
     * POST /user : Create a new user.
     *
     * @param user the user to create
     * @return the ResponseEntity with status 201 (Created), or with status 409
     * (Conflict) if the user already exists.
     */
    @PostMapping(value = "/users", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> createUser(@RequestBody User user) {

        if (userService.isUserExist(user)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        userService.saveUser(user);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
