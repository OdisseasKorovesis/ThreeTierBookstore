package com.project.bookstore.service;

import com.project.bookstore.models.Wishlist;
import com.project.bookstore.models.WishlistItem;
import com.project.bookstore.repository.RepositoryWishlistItems;
import com.project.bookstore.repository.RepositoryWishlists;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wishlistService")
public class WishlistServiceImpl implements IWishlistService {

    @Autowired
    private RepositoryWishlistItems repositoryWishlistItems;

    @Autowired
    private RepositoryWishlists repositoryWishlists;

    @Override
    public List<WishlistItem> findWishlistItemsWithWishlistId(int wishlistId) {
        return repositoryWishlistItems.findWishlistItemsWithWishlistId(wishlistId);
    }

    @Override
    public Wishlist findWishlistWithUserId(int id) {
        return repositoryWishlists.findWishlistWithUserId(id);
    }

    @Override
    public void saveWishlistItem(WishlistItem wishlistItem) {
        repositoryWishlistItems.save(wishlistItem);
    }

    @Override
    public boolean isWishlistItemExist(WishlistItem wishlistItem) {
        int wishlistItemId = wishlistItem.getBook().getId();
        if (repositoryWishlistItems.findWishlistItemWithBookId(wishlistItemId) == null) {
            return false;
        } else {
            return true;
        }
    }

}
