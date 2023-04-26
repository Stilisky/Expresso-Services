package com.services.expresso.contollers;

import com.services.expresso.models.Client;
import com.services.expresso.models.DeliveryMan;
import com.services.expresso.models.Zone;
import com.services.expresso.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expresso")
public class ExpressoRest {
    @Autowired
    private ClientServices clientServices;
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderStatusService orderStatusService;
    @Autowired
    private DeliveryServices deliveryServices;
    @Autowired
    private ZoneService zoneService;

    @GetMapping(value = "/clients")
    public List<Client> getAllClients(){
        return clientServices.allClients();
    }

    @GetMapping(value = "/clients/{id}")
    public Client getClient(@PathVariable Long id){
        return clientServices.clientById(id);
    }

    @PostMapping(value = "/clients")
    public Client saveClient(@RequestBody Client client){
        return clientServices.saveClient(client);
    }

    @PutMapping(value = "/clients/{id}")
    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        return clientServices.updateClient(id,client);
    }

    @DeleteMapping(value = "/clients/{id}")
    public void deleteClient(@PathVariable Long id){
        clientServices.deleteClient(id);
    }

    @GetMapping(value = "/zones")
    public List<Zone> getAllZones(){
        return zoneService.allZones();
    }

    @GetMapping(value = "/zones/{id}")
    public Zone getZone(@PathVariable Long id){
        return zoneService.findById(id);
    }

    @PostMapping(value = "/zones")
    public Zone saveZone(@RequestBody Zone zone){
        return zoneService.saveZone(zone);
    }

    @DeleteMapping("/zones/{id}")
    public void deleteZone(@PathVariable Long id){
        zoneService.deleteZone(id);
    }

    @GetMapping(value = "/deliveries")
    public List<DeliveryMan> getAllDeliveriesEmployes(){
        return deliveryServices.allDeliveryMan();
    }

    @GetMapping(value = "/deliveries/{id}")
    public DeliveryMan getDeliveryEmploye(@PathVariable Long id){
        return deliveryServices.getDelivery(id);
    }

    @PostMapping(value = "/deliveries")
    public DeliveryMan savedelivery(@RequestBody DeliveryMan deliveryMan){
        return deliveryServices.saveDelivery(deliveryMan);
    }

    @PutMapping(value = "/deliveries/{id}")
    public DeliveryMan updateDelivery(@PathVariable Long id, @RequestBody DeliveryMan deliveryMan){
        return deliveryServices.updateDelivery(id, deliveryMan);
    }

    @DeleteMapping(value = "/deliveries/{id}")
    public void deleteDelivery(@PathVariable Long id){
        deliveryServices.deleteDeliveryMan(id);
    }

    @GetMapping(value = "/deliveries/{star}")
    public List<DeliveryMan> getDeliveryByStar(@PathVariable Long star){
        return deliveryServices.getDeliveryByStar(star);
    }





}
