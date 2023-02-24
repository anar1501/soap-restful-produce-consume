package com.company.consumerapi.mapper;

import com.company.consumerapi.dto.request.EmployeeRequestDto;
import com.company.consumerapi.dto.request.UpdateEmployeeRequestDto;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import src.main.java.az.idrak.consumingwebservice.wsdl.AddEmployeeRequest;
import src.main.java.az.idrak.consumingwebservice.wsdl.UpdateEmployeeRequest;

import java.util.Objects;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true), imports = {Objects.class})
public interface EmployeeMapper {


    @Mapping(target = "employeeInfo.name",source = "name")
    @Mapping(target = "employeeInfo.department",source = "department")
    @Mapping(target = "employeeInfo.phone",source = "phone")
    @Mapping(target = "employeeInfo.address",source = "address")
    AddEmployeeRequest map(EmployeeRequestDto employeeRequestDto);

    @Mapping(target = "employeeInfo.name",source = "requestDto.employeeRequestDto.name")
    @Mapping(target = "employeeInfo.department",source = "requestDto.employeeRequestDto.department")
    @Mapping(target = "employeeInfo.phone",source = "requestDto.employeeRequestDto.phone")
    @Mapping(target = "employeeInfo.address",source = "requestDto.employeeRequestDto.address")
    @Mapping(target = "employeeId",source = "id")
    UpdateEmployeeRequest map(UpdateEmployeeRequestDto requestDto, Long id);
}
