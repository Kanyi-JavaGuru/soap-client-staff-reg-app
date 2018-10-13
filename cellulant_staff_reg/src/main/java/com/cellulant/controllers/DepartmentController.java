package com.cellulant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cellulant.services.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService depService;
	
	/**
	 * rest controller that finds all the Departments stored in the database
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/departments")
	public ResponseEntity<Object> findAll(){	
		return new ResponseEntity<Object>(depService.findAll(), HttpStatus.OK);
	}
}
