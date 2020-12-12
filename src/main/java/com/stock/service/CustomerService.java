package com.stock.service;

import com.stock.model.Customer;
import com.stock.service.exception.UniqueContactException;
import com.stock.service.exception.UniqueCpfException;

import java.util.List;
import java.util.Optional;

public interface CustomerService<T> {
    List<T> findAll();
    T findCustomerById(long id);
    Optional<T> findCustomerBYCPF(String cpf);
    Optional<T> findCustomerByContact(String contact);
    T save(Customer saveCustomer) throws UniqueCpfException, UniqueContactException;
    T update(long id,Customer updateCustomer);
    void delete(long id);
}
