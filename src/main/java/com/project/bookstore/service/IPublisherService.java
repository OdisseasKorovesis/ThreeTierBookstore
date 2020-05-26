package com.project.bookstore.service;

import com.project.bookstore.models.Publisher;

public interface IPublisherService {

    void savePublisher(Publisher publisher);

    boolean isPublisherExist(Publisher publisher);

}
