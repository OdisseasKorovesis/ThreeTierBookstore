package com.project.bookstore.service;

import com.project.bookstore.models.Book;
import com.project.bookstore.repository.RepositoryBooks;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchServiceImpl implements ISearchService {

    @Autowired
    private RepositoryBooks repositoryBooks;

    @Override
    public List<Book> searchBooks(String keyphrase) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
