package com.stock.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    @Column(name = "name",nullable = false,length = 250)
    private String name;

    @NotEmpty @Size(min = 11,max = 11)
    @Column(name = "cpf",nullable = false,length = 11)
    private String cpf;
    @NotEmpty
    @Column(name = "address",nullable = false)
    private String address;
    @NotEmpty  @Size(min = 11,max = 13)
    @Column(name = "contact",nullable = false,length = 13)
    private String contact;
    @Email
    @NotEmpty
    @Column(name = "email",nullable = false,length = 250)
    private String email;
    @NotEmpty  @Size(min = 11)
    @Column(name = "password",nullable = false,length = 200)
    private String password;
}
