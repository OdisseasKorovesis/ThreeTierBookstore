package com.project.bookstore.controller;

import com.project.bookstore.models.Author;
import com.project.bookstore.service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tier3")
public class AuthorController {

    @Autowired
    AuthorServiceImpl authorService;

    /**
     * GET /quote : Get a random author
     *
     * @return the ResponseEntity with status 200 (OK) and a random author in
     * the body, or with status 204 (NO CONTENT) if the random author is empty.
     */
    @GetMapping("/quote")
    public ResponseEntity<Author> getRandomQuote() {
        Author author = authorService.getRandomAuthor();
        if (author.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }
}
