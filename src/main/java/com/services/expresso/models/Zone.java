package com.services.expresso.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
