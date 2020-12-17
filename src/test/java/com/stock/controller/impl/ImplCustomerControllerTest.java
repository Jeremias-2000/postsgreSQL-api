package com.stock.controller.impl;

import com.stock.controller.TestController;
import com.stock.model.Customer;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

class ImplCustomerControllerTest extends TestController {

    @Override
    @Before
    public  void setUp(){
        super.setUp();

    }

    @Test
    void findAllCustomers() throws Exception {

    }

    @Test
    void findCustomerById() {
    }

    @Test
    void findCustomerByCpf() {
    }

    @Test
    void findCustomerByContact() {
    }

    @Test
    void saveCustomer() {
    }

    @Test
    void updateCustomerByID() {
    }

    @Test
    void deleteMappingById() {
    }
}