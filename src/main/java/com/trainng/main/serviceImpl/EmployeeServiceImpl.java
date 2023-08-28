package com.trainng.main.serviceImpl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainng.main.entity.Employee;
import com.trainng.main.exception.ResourceAlreadyExistsException;
import com.trainng.main.exception.ResourceNotFoundException;
import com.trainng.main.repository.EmployeeRepository;
import com.trainng.main.service.EmployeeService;

@Service

public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public List<Employee> getEmployeeByDomain(String domain) {
		return employeeRepository.findByDomainIgnoreCase(domain);
	}

	@Override
	public Employee addEmployee(Employee employee) {
		Optional<Employee> emp = employeeRepository.findById(employee.getEmployeeId());
		if(emp.isPresent()) {
			throw new ResourceAlreadyExistsException("Employee", "specified id");
		}
		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(String empId) {
		Optional<Employee> emp = employeeRepository.findById(empId);
		if(emp.isPresent()) {
			employeeRepository.deleteById(empId);
		}
		else {
			throw new ResourceNotFoundException("Employee", "specified id");
		}
	}

	@Override
	public Employee updateEmployee(String id, Employee employee) {
		Employee emp = employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "specified id"));
		if(Objects.nonNull(employee.getEmployeeId()) && !"".equals(employee.getEmployeeId())){
			emp.setEmployeeId(employee.getEmployeeId());
			}
		if(Objects.nonNull(employee.getFirstName()) && !"".equals(employee.getFirstName())){
			emp.setFirstName(employee.getFirstName());
			}
		if(Objects.nonNull(employee.getLastName()) && !"".equals(employee.getLastName())){
			emp.setLastName(employee.getLastName());
			}
		if(Objects.nonNull(employee.getDomain()) && !"".equals(employee.getDomain())){
			emp.setDomain(employee.getDomain());
			}
		if(Objects.nonNull(employee.getEmail()) && !"".equals(employee.getEmail())){
			emp.setEmail(employee.getEmail());
			}
		employeeRepository.save(emp);
		return emp;
	}

	
	

}
