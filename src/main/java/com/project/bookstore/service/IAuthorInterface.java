package com.project.bookstore.service;

import com.project.bookstore.models.Author;
import com.project.bookstore.models.Genre;

public interface IAuthorInterface {

    Author getRandomAuthor();

    void saveAuthor(Author author);

    boolean isAuthorExist(Author author);

}
