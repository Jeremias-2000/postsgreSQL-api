package com.stock.service.impl;

import com.stock.model.Customer;
import com.stock.repository.CustomerRepository;
import com.stock.service.exception.UniqueCpfException;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImplCustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;
    @InjectMocks
    private ImplCustomerService service;
    private Customer customer;

    private static final long ID = 1;
    private static final String NAME = "Jeremias";
    private static final String CPF = "1234567890";
    private static final String ADDRESS = "Jeremias";
    private static final String CONTACT = "Jeremias";
    private static final String EMAIL = "Jeremias";
    private static final String PASSWORD = "Jeremias";


    @BeforeEach
    void setUp() {
        service = new ImplCustomerService(customerRepository);
        customer = new Customer(ID,NAME,CPF,ADDRESS,CONTACT,EMAIL,PASSWORD);
    }

    @Test
    void findAll() {

    }

    @Test
    void findCustomerById(){
       when(customerRepository.findById(ID))
               .thenReturn(Optional.ofNullable(customer));
       service.findCustomerById(ID);
       verify(customerRepository).findById(ID);
    }

    @Test
    void save() throws UniqueCpfException {
        service.save(customer);
        verify(customerRepository).save(customer);
    }

    @Test
    void cpf_already_registered()  {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }




}