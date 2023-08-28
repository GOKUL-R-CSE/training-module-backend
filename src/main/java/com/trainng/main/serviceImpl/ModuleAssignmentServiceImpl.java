package com.trainng.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trainng.main.entity.Employee;
import com.trainng.main.entity.TrainingModule;
import com.trainng.main.repository.EmployeeRepository;
import com.trainng.main.repository.TrainingModuleRepository;
import com.trainng.main.service.ModuleAssignmentService;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ModuleAssignmentServiceImpl implements ModuleAssignmentService{
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private TrainingModuleRepository trainingModuleRepository;

	@Override
	public void assignModule(Long id, String domain) {
		TrainingModule trainingModule = trainingModuleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Training module not found"));

        List<Employee> employeesInDepartment = employeeRepository.findByDomainIgnoreCase(domain);

        for (Employee employee : employeesInDepartment) {
            trainingModule.getEmployees().add(employee);
        }

        trainingModuleRepository.save(trainingModule);
	}

	@Override
	public void assignModule(String domain) {
		
//		List<TrainingModule> modules = 
		
	}
	
	
	
}
