package com.trainng.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainng.main.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String>{

	public List<Employee> findByDomainIgnoreCase(String domain);

	public List<Employee> findByDomain(String domain);
	
}
