package com.services.expresso.services;

import com.services.expresso.models.OrderStatus;
import com.services.expresso.models.Status;
import com.services.expresso.repositories.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository repository;

    public List<OrderStatus> allOrderStatus(){
        return repository.findAll();
    }

    public OrderStatus getOrderStatusById(Long id){
        return repository.findById(id).get();
    }

    public OrderStatus updateLocationOrder(String location, Long id){
        OrderStatus updateLocation = repository.findById(id).get();
        if (!updateLocation.equals(location)){
            updateLocation.setCurrentLocation(location);
        }
        return updateLocation;
    }

    public OrderStatus updateStatusOrder(Status status, Long id){
        OrderStatus updateStatus = repository.findById(id).get();
        if (!updateStatus.getStatus().equals(status.toString())){
            updateStatus.setStatus(status);
        }
        return updateStatus;
    }

    public OrderStatus updateCurrentDate(Long id){
        OrderStatus updateStatus = repository.findById(id).get();
        updateStatus.setCurrentDate(new Date());
        return updateStatus;
    }

    public void deleteOrderStatus(Long id){
        repository.deleteById(id);
    }
}
