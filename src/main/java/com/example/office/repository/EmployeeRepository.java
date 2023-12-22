package com.example.office.repository;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import com.example.office.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{
    List<Employee> findByName(String name);
    List<Employee> findBySalaryGreaterThan(int salary);
}
