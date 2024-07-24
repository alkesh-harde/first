package com.nsa.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsa.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Serializable> {

}
