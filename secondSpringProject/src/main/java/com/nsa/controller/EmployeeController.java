package com.nsa.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsa.entity.Employee;
import com.nsa.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService service;

	@GetMapping("/getEmployeeList/{1}/{2}/{3}")
	public ResponseEntity<List<Employee>> getEmployyesByid(@PathVariable int empId1, @PathVariable int empId2,
			@PathVariable int empId3) {
		List<Employee> findlistEmp = service.findlistEmp(empId1, empId2, empId3);
		return new ResponseEntity<List<Employee>>(findlistEmp, HttpStatus.OK);
	}

}
