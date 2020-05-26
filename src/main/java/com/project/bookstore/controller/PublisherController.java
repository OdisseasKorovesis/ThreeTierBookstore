package com.project.bookstore.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.bookstore.models.Publisher;
import com.project.bookstore.service.PublisherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
     * @param name the publishers name to create
     * @return the ResponseEntity with status 201 (Created), or with status 409
     * (Conflict) if the publishers already exists.
     */
    @PostMapping(value = "/publishers", consumes = "application/json")
    public ResponseEntity<String> createPublisher(@RequestBody Publisher publisher) {

        String json = "{\"name\":\"test\"}";

        ObjectMapper mapper = new ObjectMapper();

        System.out.println(publisher);

        publisherService.savePublisher(publisher);

        if (publisherService.isPublisherExist(publisher)) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
        publisherService.savePublisher(publisher);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
