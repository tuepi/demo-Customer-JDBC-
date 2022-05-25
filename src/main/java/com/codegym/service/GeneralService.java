package com.codegym.service;

import com.codegym.model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface GeneralService<T>{
    void add(T t) throws SQLException;

    Customer findById(int id);

    List<T> findAll();

    boolean delete(int id) throws SQLException;

    boolean update(T t) throws SQLException;
}
