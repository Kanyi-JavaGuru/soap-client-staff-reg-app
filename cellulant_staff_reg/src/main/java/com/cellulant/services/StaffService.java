package com.cellulant.services;

import java.util.Optional;
import java.util.Set;

import com.cellulant.models.Staff_;

/**
 * interface to Staff DAO
 * @author kevin
 *
 */
public interface StaffService {

	/**
	 * saves entity staff to database
	 * @param staff
	 * @return
	 */
	public Staff_ save(Staff_ staff);
	
	/**
	 * finds staff entity by its id
	 * @param id
	 * @return
	 */
	public Staff_ findById(Long id);
	
	/**
	 * finds a collection set of all staff
	 * for a particular department
	 * @param department_id
	 * @return
	 */
	public Set<Staff_> findByDepartmentId(Long department_id);

	/**
	 * finds a staff and returns an optional Object 
	 * of the staff
	 * @param staff
	 * @return
	 */
	public Optional<Staff_> find(Staff_ staff);
	
	/**
	 * checks if a staff exists or not
	 * and return a boolean of true if it does exists 
	 * or false if it does not
	 * @param staff
	 * @return
	 */
	public boolean exists(Staff_ staff);

}
