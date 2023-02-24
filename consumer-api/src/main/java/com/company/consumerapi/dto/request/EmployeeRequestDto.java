package com.company.consumerapi.dto.request;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EmployeeRequestDto {
    String name;
    String department;
    String phone;
    String address;
}
