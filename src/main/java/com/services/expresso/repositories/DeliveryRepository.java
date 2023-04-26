package com.services.expresso.repositories;

import com.services.expresso.models.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryMan, Long> {
    public List<DeliveryMan> findByStar(Long star);
}
