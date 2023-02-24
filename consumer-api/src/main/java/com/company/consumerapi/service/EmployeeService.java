package com.company.consumerapi.service;

import com.company.consumerapi.config.EmployeeClient;
import com.company.consumerapi.dto.request.DeleteEmployeeRequestDto;
import com.company.consumerapi.dto.request.EmployeeRequestDto;
import com.company.consumerapi.dto.request.UpdateEmployeeRequestDto;
import com.company.consumerapi.mapper.EmployeeMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import src.main.java.az.idrak.consumingwebservice.wsdl.*;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeService {
    final EmployeeMapper employeeMapper;
    final EmployeeClient employeeClient;

    public AddEmployeeResponse addEmployee(EmployeeRequestDto requestDto) {
        AddEmployeeRequest addEmployeeRequest = employeeMapper.map(requestDto);
        return employeeClient.addEmployee(addEmployeeRequest);
    }

    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequestDto requestDto) {
        UpdateEmployeeRequest request = employeeMapper.map(requestDto, requestDto.getEmployeeId());
        return employeeClient.updateEmployee(request);
    }

    public GetEmployeeResponse getEmployeeById(Long id) {
        GetEmployeeByIdRequest request = new GetEmployeeByIdRequest();
        request.setEmployeeId(id);
        return employeeClient.getEmployeeById(request);
    }

    public DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequestDto requestDto) {
        DeleteEmployeeRequest request = new DeleteEmployeeRequest();
        request.setEmployeeId(requestDto.getEmployeeId());
        return employeeClient.deleteEmployee(request);
    }
}
