package com.services.expresso.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "zone")
public class Zone {
    @Id
    @Column(name = "zoneid")
    private Long zoneId;

    @Column(name = "zonename")
    private String zoneName;

    @OneToMany(mappedBy = "zone")
    private List<DeliveryMan> deliveryMEN;
}
