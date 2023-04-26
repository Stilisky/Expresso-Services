package com.services.expresso.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderid")
    private Long orderId;

    @Column(name = "typeproduct")
    private String typeProduct;

    @Column(name = "orderdate")
    private Date orderDate;

    @Column(name = "destination")
    private String destinationAddress;

    @Column(name = "price")
    private double price;

}
