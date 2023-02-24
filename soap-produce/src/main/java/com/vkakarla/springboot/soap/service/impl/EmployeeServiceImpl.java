package com.vkakarla.springboot.soap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vkakarla.springboot.soap.entity.Employee;
import com.vkakarla.springboot.soap.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements com.vkakarla.springboot.soap.service.EmployeeService {

	 @Autowired
	 EmployeeRepository employeeRepository;
	
	
	@Override
	public Employee getEmployeeById(long employeeId) {
		Employee obj = employeeRepository.findByEmployeeId(employeeId);
		return obj;
		
	}

	@Override
	public void AddEmployee(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	@Override
	public void deleteEmployee(long employeeId) {
		employeeRepository.deleteById(employeeId);

	}
	
}
