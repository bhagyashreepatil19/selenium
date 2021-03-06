package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	boolean addProduct(Product p);

	boolean deleteProductById(int pid);

	Product findByID(int pid);

	boolean updateProductById(Product p);

}
