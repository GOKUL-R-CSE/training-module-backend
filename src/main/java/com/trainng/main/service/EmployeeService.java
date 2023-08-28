package com.trainng.main.service;

import java.util.List;

//import org.springframework.http.ResponseEntity;

import com.trainng.main.entity.Employee;

public interface EmployeeService {

	List<Employee> getEmployee();

	List<Employee> getEmployeeByDomain(String domain);

	Employee addEmployee(Employee employee);

	void deleteEmployee(String empId);

	Employee updateEmployee(String id, Employee employee);

}
