package com.trainng.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trainng.main.entity.Employee;
import com.trainng.main.service.EmployeeService;
import com.trainng.main.service.ModuleAssignmentService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private ModuleAssignmentService moduleService;
	
	@PostMapping("/addemployee")
	public ResponseEntity<Employee> addEmployee(
			@Validated
			@RequestBody Employee employee
			){
		Employee emp = employeeService.addEmployee(employee);
		moduleService.assignModule(employee.getDomain());
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@GetMapping("/getemployee")
	public ResponseEntity<List<Employee>> getEmployee(){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployee(), HttpStatus.FOUND);
	}
	
	@GetMapping("/getemployee/{domain}")
	public ResponseEntity<List<Employee>> getEmployeeByDept(
			@PathVariable(name = "domain") String domain
			){
		return new ResponseEntity<List<Employee>>(employeeService.getEmployeeByDomain(domain), HttpStatus.FOUND);
	}
	
	@DeleteMapping("/deleteemployee/{id}")
	public String deleteEmployee(
			@PathVariable(name = "id") String empId
			) {
		employeeService.deleteEmployee(empId);
		return "Employee deleted successfully";
	}
	
	@PutMapping("/updateemployee/{id}")
	public ResponseEntity<Employee> updateEmployee(
			@PathVariable(name = "id") String id,
			@RequestBody Employee employee
			){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(id, employee), HttpStatus.ACCEPTED);
	}
	
}
