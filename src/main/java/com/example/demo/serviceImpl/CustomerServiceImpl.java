package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.exception.InvalidCredentials;
import com.example.demo.module.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo repository;
	
	BCryptPasswordEncoder b1 = new BCryptPasswordEncoder();
	
	@Override
	public Customer customerSignUp(Customer c) 
	{
		c.setCpassword(b1.encode(c.getCpassword()));
		return repository.save(c);
	}

	@Override
	public Customer customerLogin(String data, String cpassword) {
		Customer c=repository.validate(data,data);
		if(c!=null)
		{
			if(b1.matches(cpassword, c.getCpassword()))
			{
				return c;
			}
			else
			{
				throw new InvalidCredentials();
			}
		}
		else
		{
			throw new InvalidCredentials();
		}
	}

	@Override
	public String validateCustomer(String data) 
	{
		Customer c = repository.validate(data, data);
		if(c!=null)
		{
			if(c.getCname().equals(data) || c.getCemail().equals(data))
			{
				return "Data Present";
			}
			else {
				throw new InvalidCredentials();
			}
		}
		else {
			throw new InvalidCredentials();
		}
	}

	@Override
	public Customer customerUpdatePass(String data, String cpassword) {
		Customer c = repository.validate(data, data);
		if(c!=null)
		{
			cpassword=b1.encode(cpassword);
			if(c.getCname().equals(data) || c.getCemail().equals(data))
			{
				c.setCpassword(cpassword);
				repository.save(c);
				return c;
			}
			else
			{
				throw new InvalidCredentials();
			}
		}
		else
		{
			throw new InvalidCredentials();
		}
	}
	

	

}
