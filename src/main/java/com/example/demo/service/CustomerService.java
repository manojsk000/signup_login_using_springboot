package com.example.demo.service;

import com.example.demo.module.Customer;

public interface CustomerService 
{
	Customer customerSignUp(Customer c);
	
	Customer customerLogin(String data, String cpassword);
	
	String validateCustomer(String data);
	
	Customer customerUpdatePass(String data, String cpassword);
}
