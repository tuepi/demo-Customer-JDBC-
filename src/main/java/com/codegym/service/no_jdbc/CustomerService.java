package com.codegym.service.no_jdbc;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    int findIndexById(int id);

    void update(int id, Customer customer);

    void remove(int id);
}
