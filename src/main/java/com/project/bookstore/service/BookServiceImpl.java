package com.project.bookstore.service;

import com.project.bookstore.models.Book;
import com.project.bookstore.repository.RepositoryBooks;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookService")
public class BookServiceImpl implements IBookService {

    @Autowired
    private RepositoryBooks repositoryBooks;

    @Override
    public List<Book> findAllBooks() {
        List<Book> books = new ArrayList<>();
        repositoryBooks.findAll()
                .forEach(books::add);
        return books;
    }

    @Override
    public Book findById(int id) {
        return repositoryBooks.findBookById(id);
    }

    @Override
    public List<Book> findByGenre(String genre) {
        return repositoryBooks.findBookByGenre(genre);
    }

    @Override
    public List<Book> findByLanguage(String language) {
        return repositoryBooks.findBookByLanguage(language);
    }

    @Override
    public List<Book> findNRecentBooks(int n) {
        return repositoryBooks.findNRecentBooks(n);
    }

    @Override
    public List<Book> findNBestsellerBooks(int n) {
        return repositoryBooks.findNBestsellerBooks(n);
    }
//
//    @Override
//    public boolean isBookExist(Book book) {
////        TODO book exists only when id is the same?
//        return findById(book.getId()) != null;
//
//    }
//
//    @Override
//    public void saveBook(Book book) {
////      TODO  get correct ID from DB to allow controller to return correct locator uri
//        book.setId(counter.incrementAndGet());
//        books.add(book);
//    }
//
//    @Override
//    public void updateBook(Book book) {
//        int index = books.indexOf(book);
//        books.set(index, book);
//    }
//
//    @Override
//    public void deleteBookById(long id) {
//        for (Iterator<Book> iterator = books.iterator(); iterator.hasNext();) {
//            Book user = iterator.next();
//            if (user.getId() == id) {
//                iterator.remove();
//            }
//        }
//    }
}
