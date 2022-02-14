package com.luv2code.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luv2code.model.Customer;


public interface CustomerDao extends JpaRepository<Customer, Long>{
	
	
}
