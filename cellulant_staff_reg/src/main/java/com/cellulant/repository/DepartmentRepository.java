package com.cellulant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cellulant.models.Department_;

public interface DepartmentRepository extends JpaRepository<Department_, Long> {

}
