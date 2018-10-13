package com.cellulant.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cellulant.models.Department_;
import com.cellulant.repository.DepartmentRepository;
import com.cellulant.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	private static final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	private DepartmentRepository repo;
	@Override
	public Department_ save(Department_ department) {
		final Department_ dep = repo.save(department);
		log.info("Saved: "+dep);
		return dep;
	}
	@Override
	public Department_ findById(Long id) {
		return repo.findById(id).get();
	}
	@Override
	public List<Department_> findAll() {
		return repo.findAll();
	}
	@Override
	public Optional<Department_> find(Department_ department) {
		return repo.findById(department.getId());
	}
	@Override
	public boolean exists(Department_ department) {
		if(find(department).isPresent())
			return true;
		return false;
	}

}
