package com.shoppe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.Product;
import com.shoppe.persistence.repository.ProductRepository;
import com.shoppe.service.base.ProductService;

@Component
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) {
		return productRepository.saveAndFlush(product);
	}

}
