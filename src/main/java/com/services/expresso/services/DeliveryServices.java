package com.services.expresso.services;

import com.services.expresso.models.DeliveryMan;
import com.services.expresso.repositories.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServices {
    @Autowired
    private DeliveryRepository repository;

    public List<DeliveryMan> allDeliveryMan(){
        return repository.findAll();
    }

    public DeliveryMan getDelivery(Long id){
        return repository.findById(id).get();
    }

    public DeliveryMan saveDelivery(DeliveryMan deliveryMan){
        return repository.save(deliveryMan);
    }

    public DeliveryMan updateDelivery(Long id, DeliveryMan deliveryMan){
        DeliveryMan updateDelivery = repository.findById(id).get();
        if (!updateDelivery.getAddress().equals(deliveryMan.getAddress())){
            updateDelivery.setAddress(deliveryMan.getAddress());
        }

        if (!updateDelivery.getFirstname().equals(deliveryMan.getFirstname())){
            updateDelivery.setFirstname(deliveryMan.getFirstname());
        }

        if (!updateDelivery.getLastname().equals(deliveryMan.getLastname())){
            updateDelivery.setLastname(deliveryMan.getLastname());
        }

        if (!updateDelivery.getPhone().equals(deliveryMan.getPhone())){
            updateDelivery.setPhone(deliveryMan.getPhone());
        }

        if (!updateDelivery.getStar().equals(deliveryMan.getStar())){
            updateDelivery.setStar(deliveryMan.getStar());
        }

        return updateDelivery;
    }

    public void deleteDeliveryMan(Long id){
        repository.deleteById(id);
    }

    public List<DeliveryMan> getDeliveryByStar(Long star){
        return repository.findByStar(star);
    }


}
