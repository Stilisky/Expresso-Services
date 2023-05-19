package com.services.expresso.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;

import java.util.Date;

@Entity
@Data
@Table(name = "orderstatus")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statusid")
    private Long statusId;

    @Column(name = "currentlocation")
    private String currentLocation;

    @Column(name = "status")
    private Status status;

    @Column(name = "currentdate")
    private Date currentDate;

    @OneToOne(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    @JoinColumn(name = "statusid")
    private Order order;


}
