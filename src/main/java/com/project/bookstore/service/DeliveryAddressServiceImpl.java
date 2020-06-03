package com.project.bookstore.service;

import com.project.bookstore.models.DeliveryAddress;
import com.project.bookstore.repository.RepositoryDeliveryAddress;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deliveryAddressService")
public class DeliveryAddressServiceImpl implements IDeliveryAddressService {

    @Autowired
    private RepositoryDeliveryAddress repositoryDeliveryAddress;

    @Override
    public List<DeliveryAddress> findDeliveryAddressesWithUserId(int userId) {
        return repositoryDeliveryAddress.findDeliveryAddressesWithUserId(userId);
    }

}
