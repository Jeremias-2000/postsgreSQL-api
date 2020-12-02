package com.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "stock")
@NoArgsConstructor
@AllArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "description")
    private String description;
    @Column(name = "purcharsePrice")
    private double purcharsePrice;
    @Column(name = "salePrice")
    private double salePrice;
    @Column(name = "purchaseDate")
    private Date purcharseDate;
    @Column(name = "lot")
    private String lot;
}
