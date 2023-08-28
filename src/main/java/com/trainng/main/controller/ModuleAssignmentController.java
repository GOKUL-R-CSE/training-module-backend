package com.trainng.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trainng.main.service.ModuleAssignmentService;

import jakarta.persistence.EntityNotFoundException;

@RestController
public class ModuleAssignmentController {
	
	@Autowired
	private ModuleAssignmentService moduleAssignmentService;
	
	@PostMapping("/assignmodule")
	public ResponseEntity<String> assignModule(
			@RequestParam Long id,
			@RequestParam String domain
			) {
		try {
			moduleAssignmentService.assignModule(id, domain);
			return new ResponseEntity<String>("Training module added successfully", HttpStatus.OK);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<String>("Invalid training module id or domain", HttpStatus.BAD_REQUEST);
		}
	}

}
