package com.project.bookstore.service;

import com.project.bookstore.models.BasketItem;
import com.project.bookstore.repository.RepositoryBasketItems;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("basketService")
public class BasketServiceImpl implements IBasketService {

    @Autowired
    private RepositoryBasketItems repositoryBasketItems;

    @Override
    public List<BasketItem> findBasketItemsWithUserId(int id) {
        return repositoryBasketItems.findBasketItemsWithUserId(id);
    }
}
