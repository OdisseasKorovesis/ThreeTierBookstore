package com.project.bookstore.service;

import com.project.bookstore.models.Basket;
import com.project.bookstore.models.BasketItem;
import java.util.List;

public interface IBasketService {

    List<BasketItem> findBasketItemsWithUserId(int userId);

    Basket findBasketWithUserId(int userId);

    void saveBasketItem(BasketItem basketItem);

    boolean isBasketItemExist(BasketItem basketItem);

}
