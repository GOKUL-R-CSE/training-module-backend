package com.trainng.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainng.main.entity.TrainingModule;

public interface TrainingModuleRepository extends JpaRepository<TrainingModule, Long>{
	
	public TrainingModule findByName(String name);

}
