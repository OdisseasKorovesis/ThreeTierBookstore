package com.project.bookstore.controller;

import com.project.bookstore.models.Publisher;
import com.project.bookstore.service.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tier3")
public class PublisherController {

    @Autowired
    PublisherServiceImpl publisherService;

    /**
     * POST /publishers : Create a new publishers.
     *
     * @param publisher the publishers name to create
     * @return the ResponseEntity with status 201 (Created), or with status 409
     * (Conflict) if the publishers already exists.
     */
    @PostMapping(value = "/publishers", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> createPublisher(@RequestBody Publisher publisher) {

        if (publisherService.isPublisherExist(publisher)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        publisherService.savePublisher(publisher);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
