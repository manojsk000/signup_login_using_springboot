package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DoctorController 
{
	@RequestMapping("/dummycontroller")
	String dummyController()
	{
		return "hello Doctor";
	}
}
