package com.naboo.primera_fase.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private User hostelero;

    @ManyToOne
    private Product product;

    private Integer quantity;
}

