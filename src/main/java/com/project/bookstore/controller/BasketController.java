package com.project.bookstore.controller;

import com.project.bookstore.models.Basket;
import com.project.bookstore.models.BasketItem;
import com.project.bookstore.service.BasketServiceImpl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<List<BasketItem>> getAllUserBasketItems(@PathVariable("id") int id) {
        List<BasketItem> basketItems = basketService.findBasketItemsWithUserId(id);
        if (basketItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(basketItems, HttpStatus.OK);
    }

    /**
     * GET /basket:userId : Get basket id of user.
     *
     * @param id the id of the user whose basket id to retrieve.
     * @return the ResponseEntity with status 200 (OK) and the basket of the
     * user in the body, or with status 204 (NO CONTENT) if there is no basket
     * for this user in the database.
     */
    @GetMapping("/basket/{id}")
    public ResponseEntity<Basket> getUserBasketId(@PathVariable("id") int id) {
        Basket basket = basketService.findBasketWithUserId(id);
        if (basket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(basket, HttpStatus.OK);
    }

    /**
     * POST /basketItems : Create a basket item for a basket.
     *
     * @param basketItem the basketItem to create
     * @return the ResponseEntity with status 201 (Created), or with status 409
     * (Conflict) if the basketItem already exists in the basket.
     */
    @PostMapping(value = "/basketItems", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addBasketItem(@RequestBody BasketItem basketItem) {

        if (basketService.isBasketItemExist(basketItem)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        basketService.saveBasketItem(basketItem);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}