package com.project.bookstore.service;

import com.project.bookstore.models.Book;
import java.util.List;

public interface IBookService {

    List<Book> findAllBooks();

    List<Book> findByGenre(String genre);

    Book findById(int id);

//    this does not need to be implemented in dao
//    boolean isBookExist(Book book);
//
//    void saveBook(Book book);
//
//    void updateBook(Book book);
//
//    void deleteBookById(long id);
}
