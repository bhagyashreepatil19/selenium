package com.demo.service;

import java.util.List;

import com.demo.model.Product;

import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService{
	
   private ProductDao productDao;
   
   
	public ProductServiceImpl() {
	super();
	this.productDao = new ProductDaoImpl();
}


	@Override
	public List<Product> getAllProducts() {
		return productDao.findAll();
	}


	@Override
	public boolean addProduct(Product p) {
		return productDao.save(p);
	}


	@Override
	public boolean deleteProductById(int pid) {
		return productDao.deletById(pid);
	}


	@Override
	public Product findByID(int pid) {
		return productDao.findById(pid);
		
	}


	@Override
	public boolean updateProductById(Product p) {
		return productDao.updateProductById(p);
		
	}

}
