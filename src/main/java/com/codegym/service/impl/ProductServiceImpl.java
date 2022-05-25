package com.codegym.service.impl;

import com.codegym.model.Customer;
import com.codegym.model.Product;
import com.codegym.service.IProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    @Override
    public void add(Product product) throws SQLException {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Product product) throws SQLException {
        return false;
    }
}
