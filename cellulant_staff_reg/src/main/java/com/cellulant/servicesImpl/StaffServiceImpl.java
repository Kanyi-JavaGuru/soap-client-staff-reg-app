package com.cellulant.servicesImpl;

import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cellulant.models.Staff_;
import com.cellulant.repository.StaffRepository;
import com.cellulant.services.StaffService;

@Service
public class StaffServiceImpl implements StaffService{
	private static final Logger log = LoggerFactory.getLogger(StaffServiceImpl.class);

	@Autowired
	private StaffRepository repo;
	
	@Override
	public Staff_ save(Staff_ staff) {
		final Staff_ st = repo.save(staff);
		log.info("Saved: "+st);
		return st;
	}

	@Override
	public Staff_ findById(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public Set<Staff_> findByDepartmentId(Long department_id) {
		return repo.findByDepartmentId(department_id);
	}

	@Override
	public Optional<Staff_> find(Staff_ staff) {
		return repo.findById(staff.getId());
	}

	@Override
	public boolean exists(Staff_ staff) {
		if(find(staff).isPresent())
			return true;
		return false;
	}

}
