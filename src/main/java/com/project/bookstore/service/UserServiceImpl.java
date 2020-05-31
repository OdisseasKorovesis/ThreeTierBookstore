package com.project.bookstore.service;

import com.project.bookstore.models.Basket;
import com.project.bookstore.models.User;
import com.project.bookstore.models.Wishlist;
import com.project.bookstore.repository.RepositoryBaskets;
import com.project.bookstore.repository.RepositoryUsers;
import com.project.bookstore.repository.RepositoryWishlists;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private RepositoryUsers repositoryUsers;

    @Autowired
    private RepositoryBaskets repositoryBaskets;

    @Autowired
    private RepositoryWishlists repositoryWishlists;

    @Override
    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        repositoryUsers.findAll()
                .forEach(users::add);
        return users;
    }

    @Override
    public boolean isUserExist(User user) {
        if (repositoryUsers.findByUsername(user.getUsername()) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void saveUser(User user) {
        repositoryUsers.save(user);
        Basket basket = new Basket(user);
        Wishlist wishlist = new Wishlist(user);
        repositoryBaskets.save(basket);
        repositoryWishlists.save(wishlist);
    }

}
