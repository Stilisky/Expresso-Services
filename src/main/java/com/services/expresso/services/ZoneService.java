package com.services.expresso.services;

import com.services.expresso.models.Zone;
import com.services.expresso.repositories.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZoneService {
    @Autowired
    private ZoneRepository repository;

    public List<Zone> allZones(){
        return repository.findAll();
    }

    public Zone findById(Long id){
        return repository.findById(id).get();
    }

    public Zone saveZone(Zone zone){
        return repository.save(zone);
    }

    public Zone updateZone(Zone zone, Long id){
        Zone updateZone = repository.findById(id).get();
        if (! updateZone.getZoneName().equals(zone.getZoneName())){
            updateZone.setZoneName(zone.getZoneName());
        }
        return updateZone;
    }


    public void deleteZone(Long id) {
        repository.deleteById(id);
    }
}
