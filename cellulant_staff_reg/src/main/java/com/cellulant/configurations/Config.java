package com.cellulant.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.cellulant.endpoints.DepartmentsGateway;
import com.cellulant.endpoints.StaffGateway;

@Configuration
public class Config {

	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPath("com.cellulant.model");
		return marshaller;
	}

	@Bean
	public DepartmentsGateway departments(Jaxb2Marshaller marshaller) {
		DepartmentsGateway departments = new DepartmentsGateway();
		departments.setDefaultUri("https://beep2.cellulant.com:9001/assessments/Company");
		departments.setMarshaller(marshaller);
		departments.setUnmarshaller(marshaller);
		return departments;
	}
	
	@Bean
	public StaffGateway staff(Jaxb2Marshaller marshaller) {
		StaffGateway staff = new StaffGateway();
		staff.setDefaultUri("https://beep2.cellulant.com:9001/assessments/Company");
		staff.setMarshaller(marshaller);
		staff.setUnmarshaller(marshaller);
		return staff;
	}
}
