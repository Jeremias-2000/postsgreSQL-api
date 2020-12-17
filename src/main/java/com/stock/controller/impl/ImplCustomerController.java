package com.stock.controller.impl;

import com.stock.controller.CustomerController;
import com.stock.model.Customer;
import com.stock.service.exceptionService.*;
import com.stock.service.impl.ImplCustomerService;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@RequestMapping("/api/v1/customer")
public class ImplCustomerController  implements CustomerController {
    @Autowired
    private ImplCustomerService customerService;

    public ImplCustomerController(ImplCustomerService service) {
    }

    @Override
    public ResponseEntity<?> findAllCustomers() {
        return ResponseEntity.ok(customerService.findAll());
    }

    @Override
    public ResponseEntity<?> findCustomerById(long id) {
        try {
            return ResponseEntity.ok(customerService.findCustomerById(id));
        }catch(RuntimeException exception){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> findCustomerByCpf(String cpf) {
        try{
            return ResponseEntity.ok(customerService.findCustomerBYCPF(cpf));
        } catch (NotFoundException exception) {
            exception.printStackTrace();
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> findCustomerByContact(String contact) {
        return ResponseEntity.ok(customerService.findCustomerByContact(contact));
    }

    @Override
    public ResponseEntity<?> saveCustomer(Customer customer, UriComponentsBuilder uriBuilder) throws UniqueCpfException, UniqueContactException {
        URI uri = uriBuilder.path("/save/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(customerService.save(customer));
    }

    @Override
    public ResponseEntity<?> updateCustomerByID(long id,Customer customer) throws UpdateCustomerException {
        try{
            return ResponseEntity.ok(customerService.update(id,customer));
        }catch (UpdateCustomerException e){
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<?> deleteMappingById(long id) throws DeleteCustomerException {
        try{
            customerService.delete(id);
            return ResponseEntity.ok().build();
        }catch (DeleteCustomerException e){
            return ResponseEntity.notFound().build();
        }
    }
}
