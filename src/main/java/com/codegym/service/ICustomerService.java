package com.codegym.service;

import com.codegym.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerService extends GeneralService<Customer>{
    void add(Customer customer) throws SQLException;

    Customer findById(int id);

    List<Customer> findAll();

    boolean delete(int id) throws SQLException;

    boolean update(Customer customer) throws SQLException;
}
