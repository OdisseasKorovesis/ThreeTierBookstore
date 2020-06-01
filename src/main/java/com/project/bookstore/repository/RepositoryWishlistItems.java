package com.project.bookstore.repository;

import com.project.bookstore.models.Book;
import com.project.bookstore.models.WishlistItem;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryWishlistItems extends CrudRepository<WishlistItem, Integer> {

    @Query(value = "SELECT * from wishlist_items \n"
            + "JOIN wishlists ON wishlists.id=wishlist_items.wishlist_id\n"
            + "WHERE user_id=?1", nativeQuery = true)
    List<WishlistItem> findWishlistItemsWithUserId(int id);

    @Query(value = "SELECT * from wishlist_items WHERE book_id=?1", nativeQuery = true)
    Book findWishlistItemWithBookId(int id);

}
