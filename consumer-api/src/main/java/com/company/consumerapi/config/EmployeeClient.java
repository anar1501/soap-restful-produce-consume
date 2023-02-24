package com.company.consumerapi.config;

import com.company.consumerapi.enums.NameSpaceUriConstraints;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import src.main.java.az.idrak.consumingwebservice.wsdl.*;


@RequiredArgsConstructor
public class EmployeeClient extends WebServiceGatewaySupport {

    @Value("${soap.wsdl.url}")
    private final String soapWsdlUrl;
    @Value("${soap.wsdl.url}")
    private final String nameSpaceURI;

    public GetEmployeeResponse getEmployeeById(GetEmployeeByIdRequest request) {
        return (GetEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(soapWsdlUrl, request,
                        new SoapActionCallback(
                                NameSpaceUriConstraints.GetEmployeeNameSpaceURI.name()));
    }

    public AddEmployeeResponse addEmployee(AddEmployeeRequest request) {
        return (AddEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(soapWsdlUrl, request,
                        new SoapActionCallback(NameSpaceUriConstraints.AddEmployeeNameSpaceURI.name()));
    }

    public UpdateEmployeeResponse updateEmployee(UpdateEmployeeRequest request) {
        return (UpdateEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(soapWsdlUrl, request,
                        new SoapActionCallback(NameSpaceUriConstraints.UpdateEmployeeNameSpaceURI.name()));
    }

    public DeleteEmployeeResponse deleteEmployee(DeleteEmployeeRequest request) {
       return  (DeleteEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive(soapWsdlUrl, request,
                        new SoapActionCallback(NameSpaceUriConstraints.DeleteEmployeeNameSpaceURI.name()));
    }
}