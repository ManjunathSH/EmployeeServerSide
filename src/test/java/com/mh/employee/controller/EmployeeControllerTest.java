package com.mh.employee.controller;

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
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mh.employee.dto.Employee;
import com.mh.employee.repository.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	@Autowired
	TestRestTemplate restTemplate;
	
	@MockBean
	EmployeeRepository employeeRepo;
	
	@Before
	public void setup() {
		
		Employee emp = new Employee();
		emp.setEmployeeName("Manju");
		emp.setEmployeeId(1L);
		emp.setEmail("abc@abc.com");
		List<Employee> empList = new ArrayList<>();
		empList.add(emp);
		
		Mockito.doReturn(empList).when(employeeRepo).findAll();
		Mockito.doReturn(Optional.of(emp)).when(employeeRepo).findById(Mockito.anyLong());
		Mockito.doReturn(emp).when(employeeRepo).save(Mockito.any(Employee.class));
	}

	@Test
	public void getAllEmployee() {

		HttpEntity<Void> entity = new HttpEntity<>(new HttpHeaders());

		ResponseEntity<List<Employee>> responseEntity = restTemplate.exchange("/api/employee", HttpMethod.GET, entity,
				new ParameterizedTypeReference<List<Employee>>() {
				});

		assertNotNull(responseEntity.getBody());

	}

	@Test
	public void getEmployee() {

		HttpEntity<Void> entity = new HttpEntity<>(new HttpHeaders());

		ResponseEntity<Employee> responseEntity = restTemplate.exchange("/api/employee/1", HttpMethod.GET, entity,
				Employee.class);

		assertNotNull(responseEntity.getBody());

	}	

	@Test
	public void saveEmpployee() {

		Employee emp = new Employee();
		emp.setEmail("abc@abc.com");
		emp.setEmployeeName("Manju");

		HttpEntity<Employee> entity = new HttpEntity<>(emp, new HttpHeaders());

		ResponseEntity<Employee> responseEntity = restTemplate.exchange("/api/employee", HttpMethod.POST, entity,
				Employee.class);

		assertNotNull(responseEntity.getBody());

	}
}
