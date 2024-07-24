package com.nsa.service;

import java.util.List;

import com.nsa.entity.Employee;

public interface EmployeeService {

	public List<Employee> findlistEmp(int id1, int id2, int id3);

	public String deleteListEmp(int id1, int id2, int id3);

}
