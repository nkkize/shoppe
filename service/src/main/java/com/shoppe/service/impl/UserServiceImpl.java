package com.shoppe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shoppe.persistence.entity.User;
import com.shoppe.persistence.repository.UserRepository;
import com.shoppe.service.base.UserService;

@Component
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

}
