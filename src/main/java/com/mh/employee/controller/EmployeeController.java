package com.mh.employee.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mh.employee.dto.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@RequestMapping(method = RequestMethod.GET)
	public List<Employee> getAllEmployees(){
		
		return new ArrayList<>();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Employee addEmployee(){
		
		return null;
	}
	
	@RequestMapping(value="/{employeeId}", method = RequestMethod.GET)
	public Employee getEmployeeById(@PathVariable("employeeId") String employeeId){
		
		return null;
	}
}
