package com.stock.service.impl;

import com.stock.model.Customer;
import com.stock.repository.CustomerRepository;
import com.stock.service.CustomerService;
import com.stock.service.exception.ContactNotFoundException;
import com.stock.service.exception.UniqueContactException;
import com.stock.service.exception.UniqueCpfException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
                new RuntimeException("Nao foi possivel encontar id => " + id));
    }

    @Override
    public Optional<Customer> findCustomerBYCPF(String cpf) {
        return null;
    }

    @Override
    public Optional<Customer> findCustomerByContact(String contact) {
        Optional<Customer> optional = customerRepository.findByContact(contact);
        optional.orElseThrow(() -> {
             new ContactNotFoundException("Não existe pessoa com o telefone (" + contact + ")");
            return null;
        });
        return optional;
    }

    @Override
    public Customer save(Customer saveCustomer) throws UniqueCpfException, UniqueContactException {
        Optional<Customer> optional = customerRepository
                .findByCpf(saveCustomer.getCpf());
        if (optional.isPresent()){
            throw new UniqueCpfException("cpf already registered : '" + saveCustomer.getCpf() + "'");
        }
        optional = customerRepository
                .findByContact(saveCustomer.getContact());
        if(optional.isPresent()){
            throw new UniqueContactException();
        }
        return customerRepository.save(saveCustomer);

    }


    @Override
    public Customer update(long id ,Customer updateCustomer) {
        return null;
    }

    @Override
    public void delete(long id) {
        Customer deleteCustomer = customerRepository.findById(id).orElse(null);
        customerRepository.delete(deleteCustomer);
    }
}
