package com.services.expresso.contollers;

import com.services.expresso.models.Client;
import com.services.expresso.models.DeliveryMan;
import com.services.expresso.models.Zone;
import com.services.expresso.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ExpressoController {
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

    @GetMapping(value = "/")
    public String home(){
        return "index";
    }

    @GetMapping(value = "/clients")
    public String client(){
        return "client";
    }

    @GetMapping(value = "/clients/registration")
    public String clientRegistration(){
        return "clientform";
    }

    @PostMapping(value = "/clients/register")
    public String clientregister(@ModelAttribute Client client){
        System.out.println(client.toString());
        clientServices.saveClient(client);
        return "clientform";
    }

    @GetMapping(value = "/clients/all")
    public String getAllClients(Model model){
        List<Client> clients = clientServices.allClients();
        model.addAttribute("clients", clients);
        return "allclients";
    }

    @GetMapping(value = "/delivery")
    public String delivery(){
        return "delivery";
    }

    @GetMapping(value = "/deliveryregis")
    public String deliveryForm(Model model){
        List<Zone> zones = zoneService.allZones();
        model.addAttribute("zones", zones);
        return "deliveryform";
    }

    @GetMapping(value = "/zone")
    public String zone(){
        return "zoneform";
    }

    @PostMapping(value = "/zone/register")
    public String zoneRegister(@ModelAttribute Zone zone){
        zoneService.saveZone(zone);
        return "zoneform";
    }

    @PostMapping(value = "/delivery/register")
    public String deliveryRegister(@ModelAttribute DeliveryMan deliveryMan){
        deliveryServices.saveDelivery(deliveryMan);
        return "deliveryform";
    }

    @GetMapping(value = "/deliveries/all")
    public String deliveries(Model model){
        List<DeliveryMan> deliveries = deliveryServices.allDeliveryMan();
        model.addAttribute("deliveries", deliveries);
        return "alldeliveries";
    }

/*
    @GetMapping(value = "/clients/{id}")
    public String getClient(@PathVariable Long id, Model model){
        return clientServices.clientById(id);
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

*/



}
