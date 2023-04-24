package com.services.expresso.services;

import com.services.expresso.models.Client;
import com.services.expresso.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {
    @Autowired
    private ClientRepository repository;

    public List<Client> allClients(){
        return repository.findAll();
    }

    public Client clientById(Long id){
        return repository.findById(id).get();
    }

    public Client saveClient(Client client){
        return repository.save(client);
    }

    public Client updateClient(Long id, Client client){
        Client oldClient = repository.findById(id).get();
        if (!oldClient.getAddress().equals(client.getAddress())){
            oldClient.setAddress(client.getAddress());
        }

        if (!oldClient.getFirstname().equals(client.getFirstname())){
            oldClient.setFirstname(client.getFirstname());
        }

        if (!oldClient.getLastname().equals(client.getLastname())){
            oldClient.setLastname(client.getLastname());
        }

        if (!oldClient.getPhone().equals(client.getPhone())){
            oldClient.setPhone(client.getPhone());
        }

        if (!oldClient.getNationality().equals(client.getNationality())){
            oldClient.setNationality(client.getNationality());
        }

        return oldClient;
    }

    public void deleteClient(Long id){
        repository.deleteById(id);
    }
}
