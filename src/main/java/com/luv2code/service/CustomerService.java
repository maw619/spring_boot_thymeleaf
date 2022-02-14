package com.luv2code.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.luv2code.dao.CustomerDao;
import com.luv2code.model.Customer;

@Service
public class CustomerService{
	
	
	private CustomerDao customerDao;
	
	@Autowired
	public CustomerService(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}
	
	
	public List<Customer>getCustomers(){
		List<Customer>listar = customerDao.findAll();
		System.out.println("hi");
		return listar;
	}
	
	public void addCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
	public void updateCustomer(Customer customer) {
		customerDao.save(customer);
	}
	
	public Optional<Customer> getCustomerById(Long id) {
		Optional<Customer> customer = customerDao.findById(id);
		return customer;
	}
	
	public void deleteById(Long id) {
		customerDao.deleteById(id);
	}

}
