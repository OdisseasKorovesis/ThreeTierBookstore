package com.project.bookstore.service;

import com.project.bookstore.models.Basket;
import com.project.bookstore.models.BasketItem;
import com.project.bookstore.repository.RepositoryBasketItems;
import com.project.bookstore.repository.RepositoryBaskets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("basketService")
public class BasketServiceImpl implements IBasketService {

    @Autowired
    private RepositoryBasketItems repositoryBasketItems;

    @Autowired
    private RepositoryBaskets repositoryBaskets;

    @Override
    public List<BasketItem> findBasketItemsWithBasketId(int basketId) {
        return repositoryBasketItems.findBasketItemsWithBasketId(basketId);
    }

    @Override
    public Basket findBasketWithUserId(int userId) {
        return repositoryBaskets.findBasketWithUserId(userId);
    }

    @Override
    public void saveBasketItem(BasketItem basketItem) {
        repositoryBasketItems.save(basketItem);
    }

    @Override
    public boolean isBasketItemExist(BasketItem basketItem) {
        int bookItemId = basketItem.getBook().getId();
        if (repositoryBasketItems.findBasketItemWithBookId(bookItemId) == null) {
            return false;
        } else {
            return true;
        }
    }
}
