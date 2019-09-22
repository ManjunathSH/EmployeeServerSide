package com.mh.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mh.employee.dto.Employee;
import com.mh.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepo;

	public List<Employee> getAllEmployees() {

		List<Employee> employeeList = employeeRepo.findAll();

		return employeeList;
	}

	public Employee getEmployeeById(String employeeId) {

		Optional<Employee> employee = employeeRepo.findById(Long.parseLong(employeeId));

		if (employee.isPresent())
			return employee.get();
		return null;
	}

	public Employee addEmployee(Employee employee) {

		Employee savedEmployee = employeeRepo.save(employee);
		return savedEmployee;
	}

}
