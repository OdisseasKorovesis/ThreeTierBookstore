package com.project.bookstore.service;

import com.project.bookstore.models.Genre;

public interface IGenreService {

    void saveGenre(Genre genre);

    boolean isGenreExist(Genre genre);

}
