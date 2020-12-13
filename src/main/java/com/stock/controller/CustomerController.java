package com.stock.controller;

import com.stock.model.Customer;
import com.stock.service.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CustomerController {

    @GetMapping("/findAll")
    ResponseEntity<?> findAllCustomers();

    @GetMapping("/find/id/{id}")
    ResponseEntity<?> findCustomerById(@PathVariable("id") long id);

    @GetMapping("/find/cpf/{cpf}")
    ResponseEntity<?> findCustomerByCpf(@PathVariable("cpf") String cpf);

    @GetMapping("/find/contact/{contact}")
    ResponseEntity<?> findCustomerByContact(@PathVariable("contact") String contact) throws ContactNotFoundException;

    @PostMapping("/save")
    ResponseEntity<?> saveCustomer(@RequestBody Customer customer) throws UniqueCpfException, UniqueContactException;

    @PutMapping("/update/{id}")
    ResponseEntity<?> updateCustomerByID(@PathVariable("id") long id,@RequestBody Customer customer) throws UpdateCustomerException;

    @DeleteMapping("delete/{id}")
    ResponseEntity<?> deleteMappingById(@PathVariable("id") long id) throws DeleteCustomerException;
}
