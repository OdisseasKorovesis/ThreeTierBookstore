package com.project.bookstore.controller;

import com.project.bookstore.models.Wishlist;
import com.project.bookstore.models.WishlistItem;
import com.project.bookstore.service.WishlistServiceImpl;
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
public class WishlistController {

    @Autowired
    WishlistServiceImpl wishlistService;

    /**
     * GET /wishlistItems:wishlistId : Get wishlistItems of user.
     *
     * @param wishlistId the id of the wishlist whose items to retrieve.
     * @return the ResponseEntity with status 200 (OK) and the wishlistItems
     * items of the wishlist in the body, or with status 204 (NO CONTENT) if
     * there are no wishlistItems items for this wishlist in the database.
     */
    @GetMapping("/wishlistItems/{wishlistId}")
    public ResponseEntity<List<WishlistItem>> getAllUserwishlistItems(@PathVariable("wishlistId") int wishlistId) {
        List<WishlistItem> wishlistItems = wishlistService.findWishlistItemsWithWishlistId(wishlistId);
        if (wishlistItems.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wishlistItems, HttpStatus.OK);
    }

    /**
     * GET /wishlist:userId : Get wishlist id of user.
     *
     * @param userId the id of the user whose wishlist id to retrieve.
     * @return the ResponseEntity with status 200 (OK) and the wishlist of the
     * user in the body, or with status 204 (NO CONTENT) if there is no wishlist
     * for this user in the database.
     */
    @GetMapping("/wishlist/{userId}")
    public ResponseEntity<Wishlist> getUserWishlistId(@PathVariable("userId") int userId) {
        Wishlist wishlist = wishlistService.findWishlistWithUserId(userId);
        if (wishlist == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(wishlist, HttpStatus.OK);
    }

    /**
     * POST /wishlistItems : Create a wishlist item for a wishlist.
     *
     * @param wishlistItem the wishlistItem to create
     * @return the ResponseEntity with status 201 (Created), or with status 409
     * (Conflict) if the basketItem already exists in the basket.
     */
    @PostMapping(value = "/wishlistItems", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addWishlistItem(@RequestBody WishlistItem wishlistItem) {

        if (wishlistService.isWishlistItemExist(wishlistItem)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        wishlistService.saveWishlistItem(wishlistItem);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
