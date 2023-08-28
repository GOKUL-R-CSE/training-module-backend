package com.trainng.main.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class TrainingModule {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String name;
	private String description;
	private String image;
	private List<String> imageLink;
	private List<String> topics;
	private List<String> topicDes;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
	    name = "employee_training_module",
	    joinColumns = @JoinColumn(name = "id"),
	    inverseJoinColumns = @JoinColumn(name = "employee_id")
	)
//	@ManyToMany(mappedBy = "trainingModules", fetch = FetchType.EAGER)
	private List<Employee> employees;

}
