package com.project.bookstore.controller;

import com.project.bookstore.models.DeliveryAddress;
import com.project.bookstore.service.DeliveryAddressServiceImpl;
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
public class DeliveryAddressController {

    @Autowired
    DeliveryAddressServiceImpl deliveryAddressService;

    /**
     * GET /deliveryAddresses/{userId} : Get all delivery addresses of user.
     *
     * @param userId the user whose delivery addresses to retrieve
     * @return the ResponseEntity with status 200 (OK) and the list of books in
     * the body, or with status 204 (NO CONTENT) if there are no books in
     * database.
     */
    @GetMapping("/deliveryAddresses/{userId}")
    public ResponseEntity<List<DeliveryAddress>> getAllBooks(@PathVariable("userId") int userId) {
        List<DeliveryAddress> deliveryAddress = deliveryAddressService.findDeliveryAddressesWithUserId(userId);
        if (deliveryAddress.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(deliveryAddress, HttpStatus.OK);
    }
}
