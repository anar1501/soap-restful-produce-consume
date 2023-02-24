package com.company.consumerapi.controller;

import com.company.consumerapi.dto.request.DeleteEmployeeRequestDto;
import com.company.consumerapi.dto.request.EmployeeRequestDto;
import com.company.consumerapi.dto.request.UpdateEmployeeRequestDto;
import com.company.consumerapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import src.main.java.az.idrak.consumingwebservice.wsdl.AddEmployeeResponse;
import src.main.java.az.idrak.consumingwebservice.wsdl.DeleteEmployeeResponse;
import src.main.java.az.idrak.consumingwebservice.wsdl.GetEmployeeResponse;
import src.main.java.az.idrak.consumingwebservice.wsdl.UpdateEmployeeResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "/{id}")
    public GetEmployeeResponse getEmployeeById(@PathVariable(value = "id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public AddEmployeeResponse addEmployee(@RequestBody EmployeeRequestDto requestDto) {
        return employeeService.addEmployee(requestDto);
    }

    @PutMapping
    public UpdateEmployeeResponse updateEmployee(@RequestBody UpdateEmployeeRequestDto requestDto) {
        return employeeService.updateEmployee(requestDto);
    }

    @DeleteMapping
    public DeleteEmployeeResponse deleteEmployee(@RequestBody DeleteEmployeeRequestDto requestDto){
        return employeeService.deleteEmployee(requestDto);
    }

}
