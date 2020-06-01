package com.project.bookstore.service;

import com.project.bookstore.models.Basket;
import com.project.bookstore.models.BasketItem;
import java.util.List;

public interface IBasketService {

    List<BasketItem> findBasketItemsWithBasketId(int basketId);

    Basket findBasketWithUserId(int userId);

    void saveBasketItem(BasketItem basketItem);

    boolean isBasketItemExist(BasketItem basketItem);

}
