package com.project.bookstore.service;

import com.project.bookstore.models.BasketItem;
import java.util.List;

public interface IBasketService {

    List<BasketItem> findBasketItemsWithUserId(int id);

}
