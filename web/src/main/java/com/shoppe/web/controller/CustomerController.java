package com.shoppe.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoppe.persistence.entity.Customer;
import com.shoppe.service.base.CustomerService;
import com.shoppe.service.util.CustomerUtil;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CustomerUtil customerUtil;

	@RequestMapping("/newCustomer")
	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("newCustomer");

	}

	@RequestMapping("/addCustomer")
	public ModelAndView doAddCustomer(HttpServletRequest request, HttpServletResponse response) {
		Customer customer = customerUtil.requestToCustomer(request);
		Customer addedCustomer = customerService.addCustomer(customer);
		String message = "New Customer adding failed";
		if (addedCustomer.equals(null)) {
			return new ModelAndView("error", "message", message);
		} else {
			message = "New Customer adding successful";
			return new ModelAndView("success", "message", message);
		}
	}

}
