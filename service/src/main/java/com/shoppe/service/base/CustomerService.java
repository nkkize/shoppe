package com.shoppe.service.base;

import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.*;

/**
 * @author hungrymind
 *
 */
@Component
public interface CustomerService {
	public Customer addCustomer(Customer customer);

}
