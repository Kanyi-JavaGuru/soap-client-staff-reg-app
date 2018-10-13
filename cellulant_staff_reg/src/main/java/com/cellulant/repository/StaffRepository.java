package com.cellulant.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cellulant.models.Staff_;

public interface StaffRepository extends JpaRepository<Staff_, Long> {

	/**
	 * finds all staff for a particular department
	 * @param department_id
	 * @return Set<Staff>
	 */
	public Set<Staff_> findByDepartmentId(Long department_id);

}
