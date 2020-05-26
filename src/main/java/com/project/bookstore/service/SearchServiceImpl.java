package com.project.bookstore.service;

import com.project.bookstore.models.Author;
import com.project.bookstore.models.Book;
import com.project.bookstore.repository.RepositoryAuthors;
import com.project.bookstore.repository.RepositoryBooks;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchServiceImpl implements ISearchService {

    @Autowired
    private RepositoryBooks repositoryBooks;

    @Autowired
    private RepositoryAuthors repositoryAuthors;

    @Override
    public List<Book> searchBooks(String keyphrase) {
        List<Book> resultBooks = new ArrayList();
        resultBooks.addAll(repositoryBooks.searchByTitle(keyphrase));
        resultBooks.addAll(searchBooksByAuthorName(keyphrase));
        return resultBooks;
    }

    private List<Book> searchBooksByAuthorName(String keyphrase) {
        List<Book> resultBooks = new ArrayList();
        List<Author> resultAuthors = repositoryAuthors.searchByFirstName(keyphrase);
        resultAuthors.addAll(repositoryAuthors.searchByLastName(keyphrase));
        for (Author author : resultAuthors) {
            resultBooks.addAll(repositoryBooks.searchByAuthor(author.getId()));
        }
        return resultBooks;
    }

}
