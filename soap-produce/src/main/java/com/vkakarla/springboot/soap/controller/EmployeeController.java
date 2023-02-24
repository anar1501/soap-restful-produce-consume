package com.vkakarla.springboot.soap.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.vkakarla.springboot.soap.entity.Employee;
import com.vkakarla.springboot.soap.dto.AddEmployeeRequest;
import com.vkakarla.springboot.soap.dto.AddEmployeeResponse;
import com.vkakarla.springboot.soap.dto.DeleteEmployeeRequest;
import com.vkakarla.springboot.soap.dto.DeleteEmployeeResponse;
import com.vkakarla.springboot.soap.dto.EmployeeInfo;
import com.vkakarla.springboot.soap.dto.GetEmployeeByIdRequest;
import com.vkakarla.springboot.soap.dto.GetEmployeeResponse;
import com.vkakarla.springboot.soap.dto.ServiceStatus;
import com.vkakarla.springboot.soap.dto.UpdateEmployeeRequest;
import com.vkakarla.springboot.soap.dto.UpdateEmployeeResponse;
import com.vkakarla.springboot.soap.service.impl.EmployeeServiceImpl;

@Endpoint
public class EmployeeController {

	private static final String NAMESPACE_URI = "http://interfaces.soap.springboot.vkakarla.com";

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeServiceImpl.AddEmployee(employee);
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
		response.setEmployeeInfo(request.getEmployeeInfo());
		return response;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeByIdRequest")
	@ResponsePayload
	public GetEmployeeResponse getEmployee(@RequestPayload GetEmployeeByIdRequest request) {
		GetEmployeeResponse response = new GetEmployeeResponse();
		EmployeeInfo employeeInfo = new EmployeeInfo();
		BeanUtils.copyProperties(employeeServiceImpl.getEmployeeById(request.getEmployeeId()), employeeInfo);
		response.setEmployeeInfo(employeeInfo);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateEmployeeRequest")
	@ResponsePayload
	public UpdateEmployeeResponse updateEmployee(@RequestPayload UpdateEmployeeRequest request) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employee.setEmployeeId(request.getId());
		employeeServiceImpl.updateEmployee(employee);
		ServiceStatus serviceStatus = new ServiceStatus();
		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Updated Successfully");
		UpdateEmployeeResponse response = new UpdateEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteEmployeeRequest")
	@ResponsePayload
	public DeleteEmployeeResponse deleteEmployee(@RequestPayload DeleteEmployeeRequest request) {
		employeeServiceImpl.deleteEmployee(request.getEmployeeId());
		ServiceStatus serviceStatus = new ServiceStatus();

		serviceStatus.setStatus("SUCCESS");
		serviceStatus.setMessage("Content Deleted Successfully");
		DeleteEmployeeResponse response = new DeleteEmployeeResponse();
		response.setServiceStatus(serviceStatus);
		return response;
	}

}
