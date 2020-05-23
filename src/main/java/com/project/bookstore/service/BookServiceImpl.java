//package com.project.bookstore.service;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
//
//import org.springframework.stereotype.Service;
//
//@Service("bookService")
//public class BookServiceImpl implements IBookService {
//
//    private static final AtomicLong counter = new AtomicLong();
//
//    private static List<Book> books;
//
//    static {
//        books = populateDummyBooks();
//    }
//
//    public List<Book> findAllBooks() {
////       TODO dao returns books
//        return books;
//    }
//
//    private static List<Book> populateDummyBooks() {
////        TODO remove dummy books, they shoud come from db
//        List<Book> books = new ArrayList<>();
//        books.add(new Book(1, "Withering Heights"));
//        books.add(new Book(2, "Sapiens"));
//        return books;
//    }
//
//    @Override
//    public Book findById(long id) {
////        TODO get book from dao. if it does not exist return null
//        for (Book book : books) {
//            if (book.getId() == id) {
//                return book;
//            }
//        }
//        return null;
//    }
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
//
//}
