package com.example.office;


import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.office.model.Department;
import com.example.office.model.Employee;
import com.example.office.model.Project;
import com.example.office.repository.DepartmentRepository;
import com.example.office.repository.EmployeeRepository;
import com.example.office.repository.ProjectRepository;

// import ch.qos.logback.classic.Logger;

@SpringBootApplication
public class OfficeApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(OfficeApplication.class);
	
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;
	private final ProjectRepository projectRepository;

	public OfficeApplication(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository,
			ProjectRepository projectRepository) {
		this.employeeRepository = employeeRepository;
		this.departmentRepository = departmentRepository;
		this.projectRepository = projectRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(OfficeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Department department1 = new Department("IT");
		Department department2 = new Department("BC");
		departmentRepository.saveAll(Arrays.asList(department1,department2));

		Project project1 = new Project("Spring Boost");
		Project project2 = new Project("Flutter");
		projectRepository.saveAll(Arrays.asList(project1,project2));

		employeeRepository.save(new Employee("Phet", 20000, department2, project1));
		employeeRepository.save(new Employee("Q", 15000, department1, project1));
		employeeRepository.save(new Employee("Til", 25000, department2, project2));
		for (Employee employee : employeeRepository.findAll()){
			logger.info("name {}, salary {}", 
				employee.getName(), employee.getSalary()
			);
		}

		
	}

	


}
