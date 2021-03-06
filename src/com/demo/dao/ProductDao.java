package com.demo.dao;

import java.util.List;

import com.demo.model.Product;

public interface ProductDao {

	List<Product> findAll();

	boolean save(Product p);

	boolean deletById(int pid);

	Product findById(int pid);

	boolean updateProductById(Product p);

}
