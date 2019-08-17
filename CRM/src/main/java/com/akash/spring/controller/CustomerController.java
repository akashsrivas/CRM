package com.akash.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.akash.spring.entity.Customer;
import com.akash.spring.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/list")
	public String customerList(Model model)
	{
		//get customer dao
		List<Customer> customerList=customerService.getCustomer();
		//add customer to model
		model.addAttribute("customers", customerList);
		
		return "index";
	}
	
	@GetMapping("/showFormForAddCustomer")
	public String showFormForAddCustomer(Model model)
	{
		Customer theCustomer=new Customer();
		model.addAttribute("customer", theCustomer);
		return "AddCustomer";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer)
	{
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
}
