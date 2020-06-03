package com.project.bookstore.repository;

import com.project.bookstore.models.BasketItem;
import com.project.bookstore.models.Book;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryBasketItems extends CrudRepository<BasketItem, Integer> {

    @Query(value = "SELECT * from basket_items WHERE basket_id=?1", nativeQuery = true)
    List<BasketItem> findBasketItemsWithBasketId(int basketId);

    @Query(value = "SELECT * from basket_items WHERE book_id=?1", nativeQuery = true)
    Book findBasketItemWithBookId(int id);

    @Query(value = "SELECT * from basket_items WHERE basket_items.id=?1", nativeQuery = true)
    BasketItem findBasketItemById(int basketItemId);

    @Query(value = "SELECT basket_items.* from basket_items "
            + "JOIN baskets ON basket_id = basket_items.basket_id "
            + "WHERE user_id = ?1", nativeQuery = true)
    List<BasketItem> findBasketItemsByUserId(int userId);
}
