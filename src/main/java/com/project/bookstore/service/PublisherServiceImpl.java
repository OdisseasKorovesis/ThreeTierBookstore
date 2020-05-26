package com.project.bookstore.service;

import com.project.bookstore.models.Publisher;
import com.project.bookstore.repository.RepositoryPublishers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("publisherService")
public class PublisherServiceImpl implements IPublisherService {

    @Autowired
    private RepositoryPublishers repositoryPublishers;

    @Override
    public void savePublisher(Publisher publisher) {
        repositoryPublishers.save(publisher);
    }

    @Override
    public boolean isPublisherExist(Publisher publisher) {
        if (repositoryPublishers.findByName(publisher.getName()) == null) {
            return false;
        } else {
            return true;
        }
    }
}
