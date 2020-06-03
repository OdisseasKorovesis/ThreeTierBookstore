package com.project.bookstore.repository;

import com.project.bookstore.models.DeliveryAddress;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryDeliveryAddress extends CrudRepository<DeliveryAddress, Integer> {

    @Query(value = "SELECT * FROM delivery_address "
            + "JOIN delivery_address_user ON delivery_address_user.user_id = user_id "
            + "WHERE user_id = ?1", nativeQuery = true)
    List<DeliveryAddress> findDeliveryAddressesWithUserId(int userId);

}
