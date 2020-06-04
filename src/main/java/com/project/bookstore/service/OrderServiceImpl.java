package com.project.bookstore.service;

import com.project.bookstore.models.Order;
import com.project.bookstore.repository.RepositoryOrders;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {
    
    @Autowired
    private RepositoryOrders repositoryOrders;
    
    @Override
    public void saveOrder(Order order) {
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date currentDate = new Date();
        order.setOrderDate(currentDate);
        repositoryOrders.save(order);
        
    }
    
}
