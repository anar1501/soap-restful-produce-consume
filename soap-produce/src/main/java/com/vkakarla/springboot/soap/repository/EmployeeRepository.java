package com.vkakarla.springboot.soap.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vkakarla.springboot.soap.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	Employee findByEmployeeId(Long employeeId);
}
