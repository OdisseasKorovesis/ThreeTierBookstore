package com.project.bookstore.controller;

import static com.project.bookstore.BookstoreApplication.logger;
import com.project.bookstore.models.Book;
import com.project.bookstore.models.User;
import com.project.bookstore.repository.RepositoryBooks;
import com.project.bookstore.repository.RepositoryUsers;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(path = "/tier3")
@RestController
public class DemoController {

    @Autowired
    private RepositoryUsers repositoryUsers;
    private RepositoryBooks repositoryBooks;
    @PostMapping(path = "/register")
    public String registerAccount(@RequestParam String email, @RequestParam String password) {

        logger.info("Got a register request with params " + email + " " + password);
        System.out.println("Got request with params ");

        // DB add account logic
        User user = new User("nkapa", "1993", "nikos", "kapa", "nkapa@gmail.com");

        repositoryUsers.save(user);
        return "Account registered successfully!";
    }

    @GetMapping(path = "/status")
    public String getStatus() {

        System.out.println("Got request with params ");

        return "Status OK!";
    }

    @GetMapping(path = "/allUsers")
    public List<User> getUsers() {

        logger.info("Got a get all users request");
        List<User> users = new ArrayList<>();
        repositoryUsers.findAll().forEach(users::add);
        return users;
    }
    
    @GetMapping(path = "/user/{id}")
    public User getUserById(@PathVariable int id) {

        logger.info("Got a get user by id request");
        User user = repositoryUsers.findUserById(id);
        return user;
    }
    
    
    
//     @GetMapping("/books")
//    public ResponseEntity<List<Books>> getAllBooks() {
//        List<Book> books = bookService.findAllBooks();
//        if (books.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(books, HttpStatus.OK);
//    }

     @GetMapping(path = "/allBooks")
    public List<Book> getBooks() {

        logger.info("Got a get all users request");
        List<Book> books = new ArrayList<>();
        repositoryBooks.findAll().forEach(books::add);
        return books;
    }
    /**
     * GET /books/:id : Get book with id.
     *
     * @param id the id of the book to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the book,
     * or with status 404 (NOT FOUND) if the book does not exist.
     */
//    @GetMapping("/books/{id}")
//    public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
//        Book book = bookService.findById(id);
//        if (book == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(book, HttpStatus.OK);
//    }
    
     @GetMapping(path = "/book/{id}")
    public Book getBookById(@PathVariable int id) {

        logger.info("Got a get book by id request");
        Book book = repositoryBooks.findBookById(id);
        return book;
    }
    

    /**
     * POST /books : Create a new book.
     *
     * @param book the book to create
     * @return the ResponseEntity with status 201 (Created) and with location
     * header the book uri, or with status 409 (Conflict) if the book already
     * exists.
     */
//    @PostMapping("/books")
//    public ResponseEntity<String> createBook(@RequestBody Book book, UriComponentsBuilder ucBuilder) {
//
//        if (bookService.isBookExist(book)) {
//            return new ResponseEntity(HttpStatus.CONFLICT);
//        }
//        bookService.saveBook(book);
//
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
//        return new ResponseEntity<>(headers, HttpStatus.CREATED);
//    }

    /**
     * PUT /books:id : Update an existing book with id.
     *
     * @param id the id of the book to update
     * @return the ResponseEntity with state 200 (OK) and and with location
     * header the updated book uri, or with status 404 (Not found) if the book
     * does not exist.
     */
//    @PutMapping("/books/{id}")
//    public ResponseEntity<String> updateBook(@PathVariable("id") long id, @RequestBody Book book, UriComponentsBuilder ucBuilder) {
//
//        Book currentBook = bookService.findById(id);
//
//        if (currentBook == null) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
////TODO update all variables of book when entity is created
//        currentBook.setTitle(book.getTitle());
//
//        bookService.updateBook(currentBook);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
//        return new ResponseEntity<>(headers, HttpStatus.OK);
//    }

    /**
     * DELETE /books/:id : Delete book with id.
     *
     * @param id the id of the book to delete
     * @return the ResponseEntity with status 200 (OK) or status 404 (not found)
     * if book does not exist.
     */
//    @DeleteMapping("/books/{id}")
//    public ResponseEntity<Book> deleteBook(@PathVariable("id") long id) {
//
//        Book book = bookService.findById(id);
//        if (book == null) {
//            return new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
//        bookService.deleteBookById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @GetMapping(path = "/all")
//    public @ResponseBody
//    Iterable<Movie> getAllMovies() {
//        // This returns a JSON or XML with the users
//        return repository.findAll();
//    }
}
