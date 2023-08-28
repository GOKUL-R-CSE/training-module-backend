package com.trainng.main.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Employee {

	@Id
	private String employeeId;
	private String firstName;
	private String lastName;
	private String domain;
	private String email;
	

	@ManyToMany(mappedBy = "employees", fetch = FetchType.EAGER)
//	@JsonIgnore
//	@ManyToMany(fetch = FetchType.EAGER)
//	@JoinTable(
//	    name = "employee_training_module",
//	    joinColumns = @JoinColumn(name = "employee_id"),
//	    inverseJoinColumns = @JoinColumn(name = "id")
//	)
	private List<TrainingModule> trainingModules;
	
}
