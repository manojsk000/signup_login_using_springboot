package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.module.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>
{
	@Query(value="select * from customer where cemail=?1 or cname=?2", nativeQuery=true)
	Customer validate(String cemail, String cname);
	
	
}
