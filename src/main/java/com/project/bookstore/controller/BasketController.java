package com.project.bookstore.controller;

import com.project.bookstore.models.BasketItem;
import com.project.bookstore.service.BasketServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tier3")
public class BasketController {

    @Autowired
    BasketServiceImpl basketService;

    /**
     * GET /basketItems:userId : Get basket of user.
     *
     * @param id the id of the user whose basket to retrieve.
     * @return the ResponseEntity with status 200 (OK) and the basket items of
     * the user in the body, or with status 204 (NO CONTENT) if there are no
     * basket items for this user in the database.
     */
    @GetMapping("/basketItems/{id}")
    public ResponseEntity<List<BasketItem>> getAllBasketItems(@PathVariable("id") int id) {
        List<BasketItem> basketItems = basketService.findBasketItemsWithUserId(id);
        if (basketItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(basketItems, HttpStatus.OK);
    }

}
