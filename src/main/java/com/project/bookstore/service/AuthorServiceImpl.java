package com.project.bookstore.service;

import com.project.bookstore.models.Author;
import com.project.bookstore.repository.RepositoryAuthors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authorService")
public class AuthorServiceImpl implements IAuthorInterface {

    @Autowired
    private RepositoryAuthors repositoryAuthors;

    @Override
    public Author getRandomAuthor() {
        return repositoryAuthors.findRandomAuthor();
    }

    @Override
    public void saveAuthor(Author author) {
        repositoryAuthors.save(author);
    }

    @Override
    public boolean isAuthorExist(Author author) {
        if (repositoryAuthors.findByFirstName(author.getFirstName()) == null
                && repositoryAuthors.findByLastName(author.getLastName()) == null) {
            return false;
        } else {
            return true;
        }
    }

}
