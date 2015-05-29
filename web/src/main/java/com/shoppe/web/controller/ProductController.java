/**
 * 
 */
package com.shoppe.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoppe.persistence.entity.Product;
import com.shoppe.service.base.ProductService;
import com.shoppe.service.util.ProductUtil;

/**
 * @author hungrymind
 *
 */
@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductUtil productUtil;
	
	@RequestMapping("/newProduct")
	public ModelAndView addProduct(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("newProduct");
		
	}
	
	@RequestMapping("/addProduct")
	public ModelAndView doAddProduct(HttpServletRequest request, HttpServletResponse response){
		
		Product product = productUtil.requestToProduct(request);
		Product addedProduct = productService.addProduct(product);
		String message = "New Product Addition Failed";
		if(addedProduct.equals(null)){
			return new ModelAndView("error","message",message);
		}
		else{
			message = "New Product Addition Successful";
			return new ModelAndView("success","message",message);
		}
		
	}

}
