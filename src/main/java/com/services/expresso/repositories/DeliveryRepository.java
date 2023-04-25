package com.services.expresso.repositories;

import com.services.expresso.models.DeliveryMan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends JpaRepository<DeliveryMan, Long> {
}
