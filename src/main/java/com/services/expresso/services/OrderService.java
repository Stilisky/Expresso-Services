package com.services.expresso.services;

import com.services.expresso.models.Order;
import com.services.expresso.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> allOrders(){
        return repository.findAll();
    }

    public Order findOrder(Long id){
        return repository.findById(id).get();
    }

    public Order newOrder(Order order){
        return repository.save(order);
    }
    public void  deleteOrder(Long id){
        repository.deleteById(id);
    }


}
