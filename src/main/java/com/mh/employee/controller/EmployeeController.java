package com.mh.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mh.employee.dto.Employee;
import com.mh.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(method = RequestMethod.GET)
	@CrossOrigin
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@CrossOrigin
	public Employee addEmployee(@RequestBody Employee employee)
	{
		return employeeService.addEmployee(employee);
	}
	
	@RequestMapping(value="/{employeeId}", method = RequestMethod.GET)
	@CrossOrigin
	public Employee getEmployeeById(@PathVariable("employeeId") String employeeId)
	{
		return employeeService.getEmployeeById(employeeId);
	}
}
