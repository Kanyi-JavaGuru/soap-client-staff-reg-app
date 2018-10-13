package com.cellulant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cellulant.services.StaffService;

@RestController
public class StaffController {

	@Autowired
	private StaffService staffService;
	
	/**
	 * returns all staff associated with a particular department
	 * @param id
	 * @return ResponseEntity
	 */
	@GetMapping(value = "/staff/department/{id}")
	public ResponseEntity<Object> findStaffByDepartmentId(@PathVariable("id") Long id){
		return new ResponseEntity<Object>(staffService.findByDepartmentId(id), HttpStatus.OK);
	}
}
