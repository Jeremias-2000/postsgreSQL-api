package com.stock.service.impl;

import com.stock.model.Customer;
import com.stock.repository.CustomerRepository;
import com.stock.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplCustomerService implements CustomerService<Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    public ImplCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(long id) {
        return customerRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Nao foi possivel encontarr id" + id));
    }

    @Override
    public Customer save(Customer saveCustomer) {
        return customerRepository.save(saveCustomer);
    }

    @Override
    public Customer update(Customer updateCustomer) {
        return null;
    }

    @Override
    public void delete(long id) {
        Customer deleteCustomer = customerRepository.findById(id).orElse(null);
        customerRepository.delete(deleteCustomer);
    }
}
