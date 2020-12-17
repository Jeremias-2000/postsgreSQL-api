package com.stock.service.impl;

import com.stock.model.Customer;
import com.stock.repository.CustomerRepository;
import com.stock.service.exceptionService.DeleteCustomerException;
import com.stock.service.exceptionService.UniqueContactException;
import com.stock.service.exceptionService.UniqueCpfException;
import com.stock.service.exceptionService.UpdateCustomerException;
import javassist.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
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
    private static final String CONTACT = "932215521";
    private static final String EMAIL = "Jeremias";
    private static final String PASSWORD = "Jeremias";
    List<Customer> customers = Arrays.asList(customer);

    @BeforeEach
    void setUp() throws Exception{
        service = new ImplCustomerService(customerRepository);
        customer = new Customer(ID,NAME,CPF,ADDRESS,CONTACT,EMAIL,PASSWORD);

    }

    @Test
    @DisplayName("get all customers")
    void findAll() {
        when(customerRepository.findAll())
                .thenReturn(customers);
        service.findAll();
        verify(customerRepository).findAll();

    }

    @Test
    @DisplayName("Find especific id")
    void findCustomerById(){
       when(customerRepository.findById(ID))
               .thenReturn(ofNullable(customer));
       service.findCustomerById(ID);
       verify(customerRepository).findById(ID);
    }

    @Test
    @DisplayName("find by cpf")
    void findByCpf() throws NotFoundException {
        when(customerRepository.findByCpf(CPF)).thenReturn(ofNullable(customer));
        Optional<Customer> search = service.findCustomerBYCPF(CPF);
        assertThat(search).isNotNull();
        assertEquals(search, ofNullable(customer));
        verify(customerRepository).findByCpf(CPF);
    }

    @Test
    @DisplayName("save customer")
    void should_save_in_repository() throws UniqueCpfException, UniqueContactException {
        service.save(customer);
        verify(customerRepository).save(customer);
    }

    @Test
    @DisplayName("Test CPF exception")
    void should_not_save_equal_cpfs() {
        when(customerRepository.findByCpf(CPF)).thenReturn(of(customer));

        UniqueCpfException e = assertThrows(UniqueCpfException.class, () -> service.save(customer));
        assertEquals("cpf already registered : '" + CPF + "'", e.getMessage());
        verify(customerRepository).findByCpf(CPF);
    }

    @Test
    @DisplayName("Test Contacts exception")
    void should_not_save_equal_contacts() throws Exception, UniqueCpfException {
    when(customerRepository.findByContact(CONTACT)).thenReturn(ofNullable(customer));
        assertThrows(UniqueContactException.class, () -> service.save(customer));
    }

    @Test
    @DisplayName("update customer")
    void update() throws UpdateCustomerException {
        when(customerRepository.findById(ID))
                 .thenReturn(ofNullable(customer));

        service.update(ID,customer);
    }

    @Test
    @DisplayName("delete customer")
    void delete() throws DeleteCustomerException {
        when(customerRepository.findById(ID))
                .thenReturn(ofNullable(customer));

       service.delete(ID);

    }




}