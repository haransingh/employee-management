package com.fiveExceptions;

import com.fiveExceptions.entity.Department;
import com.fiveExceptions.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class EmployeeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

	private static final Logger log = LoggerFactory.getLogger(EmployeeManagementSystemApplication.class);


	@Bean
	CommandLineRunner initDatabase(DepartmentRepository departmentRepository) {
		return args -> {
			log.info("Preloading " + departmentRepository.save(new Department(1l, "Development")));
			log.info("Preloading " + departmentRepository.save(new Department(2l, "HR")));
		};
	}

}
