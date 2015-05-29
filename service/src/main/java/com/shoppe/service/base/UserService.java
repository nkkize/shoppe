package com.shoppe.service.base;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.*;

/**
 * @author NarenderK
 *
 */
@Component
public interface UserService {
	
	public List<User> getUsers();
	public User findUser(String userName);
	public User saveNewUser(User user);

}
