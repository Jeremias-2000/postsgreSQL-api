package com.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Data
@Entity
@Table(name = "stock")
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "description",nullable = false)
    private String description;

    @Column(name = "price",nullable = false)
    private double price;

    @Column(name = "sale_price",nullable = false)
    private double sale_price;

    @Column(name = "purcharse_date",nullable = false,length = 8)
    private String purcharse_date;
    @Column(name = "lot",nullable = false)
    private String lot;
}
