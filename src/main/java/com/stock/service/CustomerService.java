package com.stock.service;

import com.stock.model.Customer;
import com.stock.service.exception.DeleteCustomerException;
import com.stock.service.exception.UniqueContactException;
import com.stock.service.exception.UniqueCpfException;
import com.stock.service.exception.UpdateCustomerException;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CustomerService<T> {
    List<T> findAll();
    T findCustomerById(long id);
    Optional<T> findCustomerBYCPF(String cpf) throws NotFoundException;
    Optional<T> findCustomerByContact(String contact);
    T save(Customer saveCustomer) throws UniqueCpfException, UniqueContactException;
    T update(long id,Customer updateCustomer) throws UpdateCustomerException;
    void delete(long id) throws DeleteCustomerException;
}
