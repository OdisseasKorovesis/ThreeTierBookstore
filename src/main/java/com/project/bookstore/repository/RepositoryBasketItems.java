package com.project.bookstore.repository;

import com.project.bookstore.models.BasketItem;
import com.project.bookstore.models.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryBasketItems extends CrudRepository<BasketItem, Integer> {

    @Query(value = "SELECT * from basket_items \n"
            + "JOIN baskets on baskets.id=basket_items.basket_id\n"
            + "WHERE user_id=?1", nativeQuery = true)
    List<BasketItem> findBasketItemsWithUserId(int id);

    @Query(value = "SELECT * from basket_items WHERE book_id=?1", nativeQuery = true)
    Book findBasketItemWithBookId(int id);

}
