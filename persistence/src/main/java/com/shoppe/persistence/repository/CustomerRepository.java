package com.shoppe.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppe.persistence.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
