package com.project.bookstore.repository;

import com.project.bookstore.models.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryBooks extends CrudRepository<Book, Integer> {

    Book findBookById(Integer id);

    @Query(value = "SELECT * FROM books JOIN genre ON books.genre_id = genre.id\n"
            + "HAVING genre.name = ?1", nativeQuery = true)
    List<Book> findBookByGenre(String genre);

    @Query(value = "SELECT * FROM books JOIN languages ON books.language_id = languages.id\n"
            + "HAVING languages.name = ?1", nativeQuery = true)
    List<Book> findBookByLanguage(String language);
}
