package com.shoppe.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shoppe.persistence.entity.User;
import com.shoppe.persistence.repository.UserRepository;
import com.shoppe.service.base.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUser(String userName) {
		return userRepository.findByUsername(userName);
	}

	@Override
	public User saveNewUser(User user) {
		return userRepository.saveAndFlush(user);
	}

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {
		return userRepository.findByUsername(userName);
	}

}
