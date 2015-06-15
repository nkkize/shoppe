package com.shoppe.persistence.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppe.persistence.entity.User;

/**
 * @author NarenderK
 *
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	
	Logger logger = LoggerFactory.getLogger(UserRepository.class);

	User findByUsername(String userName);
	
}
