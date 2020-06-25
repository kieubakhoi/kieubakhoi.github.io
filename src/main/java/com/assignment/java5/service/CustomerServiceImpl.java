package com.assignment.java5.service;

import com.assignment.java5.model.Customer;
import com.assignment.java5.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {

        return  customerRepository.findById(id);
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void remove(Long id) {
customerRepository.remove(id);
    }
}
