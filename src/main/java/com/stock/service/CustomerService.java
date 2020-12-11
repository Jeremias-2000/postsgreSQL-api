package com.stock.service;

import com.stock.model.Customer;
import com.stock.service.exception.UniqueCpfException;

import java.util.List;

public interface CustomerService<T> {
    List<T> findAll();
    T findCustomerById(long id);
    T save(Customer saveCustomer) throws UniqueCpfException;
    T update(Customer updateCustomer);
    void delete(long id);
}
