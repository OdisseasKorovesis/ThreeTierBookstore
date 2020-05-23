package com.project.bookstore.controller;

import com.project.bookstore.models.Book;
import com.project.bookstore.service.BookServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tier3")
public class GenreController {

    @Autowired
    BookServiceImpl bookService;

    /**
     * GET /genre:genre : Get books by genre
     *
     * @param genre the genre of the books to retrieve
     * @return the ResponseEntity with status 200 (OK) and a list of books by
     * genre the body, or with status 204 (NO CONTENT) if there are no books of
     * this genre.
     */
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Book>> getBooksByGenre(@PathVariable("genre") String genre) {
        List<Book> books = bookService.findByGenre(genre);
        if (books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
