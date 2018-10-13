package com.cellulant.services;

import java.util.List;
import java.util.Optional;

import com.cellulant.models.Department_;

/**
 * interface to Department DAO
 * @author kevin
 *
 */
public interface DepartmentService {

	/**
	 * saves a department entity to database
	 * @param department
	 * @return Department
	 */
	public Department_ save(Department_ department);
	
	/**
	 * finds a department by its id
	 * @param id
	 * @return Department
	 */
	public Department_ findById(Long id);

	/**
	 * finds all departments
	 * @return List<Department>
	 */
	public List<Department_> findAll();
	
	/**
	 * finds a department and returns an optional Object 
	 * of the department
	 * @param department
	 * @return
	 */
	public Optional<Department_> find(Department_ department);
	
	/**
	 * checks if a department exists or not
	 * and return a boolean of true if it does exists 
	 * or false if it does not
	 * @param department
	 * @return
	 */
	public boolean exists(Department_ department);
}
