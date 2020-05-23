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
}
