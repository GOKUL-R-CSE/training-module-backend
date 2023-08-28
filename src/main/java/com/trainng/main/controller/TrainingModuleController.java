package com.trainng.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

import com.trainng.main.entity.TrainingModule;
import com.trainng.main.service.TrainingModuleService;

@RestController

public class TrainingModuleController {
	
	@Autowired
	private TrainingModuleService moduleService;
	
	private final Logger LOGGER = LoggerFactory.getLogger(Module.class);
	
	
	@PostMapping("/addmodule")
	public ResponseEntity<TrainingModule> addModule (
			@Validated
			@RequestBody TrainingModule module
			) {
		
		LOGGER.info("adding module block");
		return new ResponseEntity<TrainingModule>(moduleService.addModule(module), HttpStatus.CREATED);
	}
	
	@GetMapping("/getmodule")
	public ResponseEntity<List<TrainingModule>> getmodule() {
		LOGGER.info("all modules retrieval block");
		return new ResponseEntity<List<TrainingModule>>(moduleService.getModule(), HttpStatus.FOUND);
	}
	
	@GetMapping("/getmodule/{id}")
	public TrainingModule getModuleById(
			@PathVariable(name = "id") long id
			) {
		LOGGER.info("get module by id block");
		return moduleService.getModuleById(id);
	}
	
	@DeleteMapping("/deletemodule/{id}")
	public ResponseEntity<String> deleteModule(
			@PathVariable(name = "id") long id
			) {
		moduleService.deleteModule(id);
		LOGGER.info("delete module block");
		return new ResponseEntity<String>("module deleted successfully", HttpStatus.OK);
	}
	
	@PutMapping("/updatemodule/{id}")
	public TrainingModule updateModule(
			@PathVariable(name = "id") long id,
			@RequestBody TrainingModule module
			){
		LOGGER.info("update module block");
		return moduleService.updateModule(id, module);
	}

}
