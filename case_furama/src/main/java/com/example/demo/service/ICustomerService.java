package com.example.demo.service;

import com.example.demo.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findByName(Pageable pageable, String name );
    void save(Customer customer);
    void remove(int id);
    Customer findById(int id);

}
