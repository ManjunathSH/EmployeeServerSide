package com.mh.employee.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mh.employee.dto.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Override
	List<Employee> findAll();
}
