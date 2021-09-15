package com.william.mockito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.william.mockito.model.Employee;
import com.william.mockito.model.Response;
import com.william.mockito.repository.EmployeeRepository;

@RestController
@RequestMapping("/EmployeeService")
public class EmployeeController {
	
	@Autowired 
	private EmployeeRepository employeeRepository;

	@GetMapping("/getEmployees")
	public Response getEmployees() {
		System.out.println("here1");
		List<Employee> empList = employeeRepository.findAll();
		System.out.println(empList.toString());
		Response response = new Response("employee record count is " + empList.size(), Boolean.TRUE);
		return response;
	}
	
	@PostMapping("/addEmployee")
	public Response addEmployees(@RequestBody Employee employee) {
		System.out.println("Here1");
		Employee empSavedEmployee = employeeRepository.save(employee);
		System.out.println("Here2");
		Response response = new Response("employee added is " + empSavedEmployee.getId(), Boolean.TRUE);
		//Response response = new Response("employee added is Willie", true);
		//Response response = new Response();
		//response.setMessage("Willie");
		//response.setStatus(true);
		System.out.println("Here3");
		System.out.println("Here4" + response.getMessage());
		System.out.println("Here5" + response.getStatus());
		return response;
	}
	
}
