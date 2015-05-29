package com.shoppe.service.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.Customer;

@Component
public class CustomerUtil {
	
	public Customer requestToCustomer(HttpServletRequest request){
		
		Customer customer = new Customer();
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String contactNumber = request.getParameter("contactNum");
		Long contactNum = Long.parseLong(contactNumber);
		String address = request.getParameter("address");
		
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setContactNum(contactNum);
		customer.setAddress(address);
		return customer;
	}

}
