package com.luv2code.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.model.Customer;
import com.luv2code.service.CustomerService;

@Controller
@RequestMapping("/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public String home(Model m) {
		m.addAttribute("listar", customerService.getCustomers());
		return "index.html";
	}
	
	@GetMapping("/goToForm")
	public String goToForm(Model model){
			Customer customer = new Customer();
			model.addAttribute("customer", customer);
		 return "add.html";
	}
	
	@PostMapping("/adduser")
	public String addCustomers(@ModelAttribute("customer") Customer customer){
		 customerService.addCustomer(customer);
		 return "redirect:/";
	}
	
	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("id") Long id, Model model) {
		Optional<Customer> customer = customerService.getCustomerById(id);
		model.addAttribute("customer", customer);
		return "update.html";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("customer") Customer customer) {
		customerService.updateCustomer(customer);
		return "redirect:/";
	}
	
	@GetMapping("/delete")
	public String deleteById(@RequestParam("id") Long id) {
		customerService.deleteById(id);
		return "redirect:/";
	}
	
	
	
	
	
	
	
	
	
}
