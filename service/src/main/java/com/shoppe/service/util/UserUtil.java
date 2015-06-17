/**
 * 
 */
package com.shoppe.service.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.User;

/**
 * @author hungrymind
 *
 */
@Component
public class UserUtil {

	public User reuestToUser(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String contactNumber = request.getParameter("contactNum");
		Long contactNum = Long.parseLong(contactNumber);
		String address = request.getParameter("address");
		
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setContactNum(contactNum);
		user.setAddress(address);
		
		return user;
	}

}
