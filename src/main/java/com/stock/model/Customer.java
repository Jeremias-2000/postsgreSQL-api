package com.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false,length = 250)
    private String name;
    @Column(name = "cpf",nullable = false,length = 11)
    private String cpf;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "contact",nullable = false,length = 13)
    private String contact;
    @Column(name = "email",nullable = false,length = 250)
    private String email;
    @Column(name = "password",nullable = false,length = 200)
    private String password;
}
