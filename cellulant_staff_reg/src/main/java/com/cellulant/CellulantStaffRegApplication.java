package com.cellulant;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cellulant.endpoints.DepartmentsGateway;
import com.cellulant.endpoints.StaffGateway;
import com.cellulant.model.Departments;
import com.cellulant.model.FetchDepartmentsResponse;
import com.cellulant.model.FetchStaffResponse;
import com.cellulant.model.Staff;
import com.cellulant.models.Department_;
import com.cellulant.models.Staff_;
import com.cellulant.services.DepartmentService;
import com.cellulant.services.StaffService;

@SpringBootApplication
public class CellulantStaffRegApplication implements CommandLineRunner{

	@Autowired
	private DepartmentsGateway deptService;	
	@Autowired
	private StaffGateway staffService;
	@Autowired
	private DepartmentService storeDept;
	@Autowired
	private StaffService storeStaff;
	
	public static void main(String[] args) {
		SpringApplication.run(CellulantStaffRegApplication.class, args);
	}

	/**
	 * on start up this method will run and retrieve all departments and its staff and save them to 
	 * the database checking if they exists or not
	 */
	@Override
	public void run(String... args) throws Exception {
		final FetchDepartmentsResponse response = deptService.getDepartments();
		response.getReturn().stream().forEach(dept->{			
			final Department_ department = saveDepartment(dept);
			final FetchStaffResponse staffResponse = staffService.getStaff(dept.getDepartmentID());
			staffResponse.getReturn().stream().forEach(staff->{
				saveStaff(department, staff);
			});
		});
	}

	/**
	 * saves staff while checking if they exists in the database
	 * @param Department_
	 * @param Staff
	 */
	private void saveStaff(final Department_ dep, final Staff staff) {
		final Staff_ staff2 = new Staff_(staff.getStaffID().longValue(), staff.getFirstName(), staff.getLastName(), staff.getEmailAddress(), 
				staff.getDateModified(), staff.getDateCreated(), dep);
		final Optional<Staff_> sta = storeStaff.find(staff2);
		if(!sta.isPresent())
			storeStaff.save(staff2);
	}

	/**
	 * saves a department while checking if it exists in the database
	 * @param Departments
	 * @return Department_
	 */
	private Department_ saveDepartment(final Departments dept) {
		final Department_ department = new Department_(dept.getDepartmentID().longValue(), dept.getName(), 
			dept.getDescription(), dept.getDateModified(), dept.getDateCreated());
		final Optional<Department_> dep = storeDept.find(department);
		if(!dep.isPresent()) 
			return storeDept.save(department);
		return dep.get();
	}
}
