package com.mh.employee.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.mh.employee.dto.Employee;
import com.mh.employee.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	EmployeeService employeeService;
	
	@MockBean
	EmployeeRepository employeeRepo;
	
	
	@Before
	public void setup() {
		Employee emp = new Employee();
		emp.setEmployeeName("Manju");
		emp.setEmail("abc@abc.com");
		List<Employee> empList = new ArrayList<>();
		empList.add(emp);
		
		Mockito.doReturn(empList).when(employeeRepo).findAll();
		Mockito.doReturn(Optional.of(emp)).when(employeeRepo).findById(Mockito.anyLong());
		Mockito.doReturn(emp).when(employeeRepo).save(Mockito.any(Employee.class));
		
	}
	
	
	@Test
	public void findAllEmployee()
	{
		List<Employee> updatedList = employeeService.getAllEmployees();
		
		assertEquals(updatedList.size(), 1);
	}
	
	@Test
	public void findEmployeeById()
	{
			
		Employee updatedEmp = employeeService.getEmployeeById("1");
		
		assertNotNull(updatedEmp);
	}
	
	@Test
	public void saveEmployee()
	{	
			
		Employee emp = new Employee();
		emp.setEmployeeName("Manju");
		emp.setEmail("xyz@xuz.com");
		
		Employee updatedEmp = employeeService.addEmployee(emp);
		
		assertNotNull(updatedEmp);
	}
	
}
