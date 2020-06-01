package com.project.bookstore.service;

import com.project.bookstore.models.Wishlist;
import com.project.bookstore.models.WishlistItem;
import java.util.List;

public interface IWishlistService {

    List<WishlistItem> findWishlistItemsWithUserId(int id);

    Wishlist findWishlistWithUserId(int id);

    void saveWishlistItem(WishlistItem wishlistItem);

    boolean isWishlistItemExist(WishlistItem wishlistItem);

}
