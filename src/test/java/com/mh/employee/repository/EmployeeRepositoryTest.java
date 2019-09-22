package com.mh.employee.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.mh.employee.dto.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
	
	@Autowired
	TestEntityManager entity;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	private static Long id;
	
	@Before
	public void setup()
	{
		Employee employee = new Employee();
		employee.setEmployeeName("Manju");
		employee.setEmail("abc@abc.com");
		
		id = (Long) entity.persistAndGetId(employee);
		
 	}
	
	@Test
	public void findAllEmployee()
	{
		List<Employee> employeeList = employeeRepo.findAll();
		
		assertEquals(employeeList.size(), 1);
	}
	
	@Test
	public void findById()
	{
		Optional<Employee> employee = employeeRepo.findById(id);
		assertNotNull(employee.get());
	}
	
	@Test
	public void saveEmployee()
	{
		Employee emp = new Employee();
		emp.setEmployeeName("Man");
		emp.setEmail("xyz@xyz.com");
		
		Employee savedEmployee = employeeRepo.save(emp);
		assertNotNull(savedEmployee.getEmployeeId());
	}
}
