package com.project.bookstore.service;

import com.project.bookstore.models.Book;
import java.util.List;

public interface ISearchService {

    List<Book> searchBooks(String keyphrase);

}
