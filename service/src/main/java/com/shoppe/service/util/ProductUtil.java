package com.shoppe.service.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.Product;

@Component
public class ProductUtil {
	
	public Product requestToProduct(HttpServletRequest request) {
		Product product = new Product();
		
		String productName = request.getParameter("productName");
		String manufacturer = request.getParameter("manufacturer");
		String price = request.getParameter("pricePerUnit");
		Double pricePerUnit = Double.parseDouble(price);
		String description = request.getParameter("description");
		
		product.setProductName(productName);
		product.setManufacturer(manufacturer);
		product.setPricePerUnit(pricePerUnit);
		product.setDescription(description);
		
		return product;
	}

}
