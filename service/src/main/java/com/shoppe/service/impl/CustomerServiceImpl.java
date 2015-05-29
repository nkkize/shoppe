package com.shoppe.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.Customer;
import com.shoppe.persistence.repository.CustomerRepository;
import com.shoppe.service.base.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository CustomerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		return CustomerRepository.saveAndFlush(customer);
	}

}
