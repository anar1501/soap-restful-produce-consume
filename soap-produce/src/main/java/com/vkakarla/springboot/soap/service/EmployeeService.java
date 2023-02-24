package com.vkakarla.springboot.soap.service;

import com.vkakarla.springboot.soap.entity.Employee;

public interface EmployeeService {

	 void AddEmployee(Employee employee);
	 
	 Employee getEmployeeById(long employeeId);
	 
     void updateEmployee(Employee employee);
     
     void deleteEmployee(long employeeId);
}
