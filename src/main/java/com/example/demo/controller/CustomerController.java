package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Customer;
import com.example.demo.service.CustomerService;

@RestController
@CrossOrigin
public class CustomerController 
{
	@Autowired
	CustomerService service;
	
	//localhost:8892/CustomerSignUp
	@PostMapping("/CustomerSignUp")
	ResponseEntity<Customer> customerSignUp(@RequestBody Customer c)
	{
		return new ResponseEntity<Customer>(service.customerSignUp(c), HttpStatus.CREATED);
	}
	
	//localhost:8892/CustomerLogin
	@GetMapping("/CustomerLogin")
	ResponseEntity<Customer> customerLogin(@RequestHeader String data, @RequestHeader String cpassword)
	{
		return new ResponseEntity<Customer> (service.customerLogin(data, cpassword), HttpStatus.ACCEPTED);
	}
	
	//localhost:8892/ValidateCustomer
	@GetMapping("/ValidateCustomer")
	ResponseEntity<String> validateCustomer(@RequestHeader String data)
	{
		return new ResponseEntity<String> (service.validateCustomer(data), HttpStatus.FOUND);
	}
	
	//localhost:8892/CustomerUpdatePass
	@PutMapping("/CustomerUpdatePass")
	ResponseEntity<Customer> customerUpdatePass(@RequestHeader String data, @RequestHeader String cpassword)
	{
		return new ResponseEntity<Customer> (service.customerUpdatePass(data, cpassword), HttpStatus.FOUND);
	}
}
