package com.stock.controller.impl;

import com.stock.controller.CustomerController;
import com.stock.model.Customer;
import com.stock.service.exception.*;
import com.stock.service.impl.ImplCustomerService;
import javassist.NotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@RequestMapping("/api/v1/customer")
public class ImplCustomerController  implements CustomerController {
    @Autowired
    private ImplCustomerService customerService;

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
    public ResponseEntity<?> findCustomerByContact(String contact) throws ContactNotFoundException {
        return ResponseEntity.ok(customerService.findCustomerByContact(contact));
    }

    @Override
    public ResponseEntity<?> saveCustomer(Customer customer) throws UniqueCpfException, UniqueContactException {
       try{
            return ResponseEntity.ok(customerService.save(customer));
       } catch (UniqueCpfException exception) {
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       }catch (UniqueContactException e){
           return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
       }
    }

    @Override
    public ResponseEntity<?> updateCustomerByID(long id,Customer customer) throws UpdateCustomerException {
        try{
            return ResponseEntity.ok(customerService.update(id,customer));
        }catch(MethodNotAllowed exception){
            return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
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
