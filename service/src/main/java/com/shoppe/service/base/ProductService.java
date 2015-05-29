package com.shoppe.service.base;

import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.Product;

@Component
public interface ProductService {
	
	public Product addProduct(Product product);

}
