package com.company.consumerapi.enums;

public enum NameSpaceUriConstraints {
    AddEmployeeNameSpaceURI("http://interfaces.soap.springboot.vkakarla.com/AddEmployeeRequest"),
    GetEmployeeNameSpaceURI("http://interfaces.soap.springboot.vkakarla.com/GetEmployeeByIdRequest"),
    UpdateEmployeeNameSpaceURI("http://interfaces.soap.springboot.vkakarla.com/UpdateEmployeeRequest"),
    DeleteEmployeeNameSpaceURI("http://interfaces.soap.springboot.vkakarla.com/DeleteEmployeeRequest");
    private final String uri;
    NameSpaceUriConstraints(String uri) {
        this.uri = uri;
    }
}
