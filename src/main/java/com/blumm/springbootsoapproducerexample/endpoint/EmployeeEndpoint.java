package com.blumm.springbootsoapproducerexample.endpoint;

import com.blumm.producing_ws.GetEmployeeRequest;
import com.blumm.producing_ws.GetEmployeeResponse;
import com.blumm.springbootsoapproducerexample.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {

    private static final String NAMESPACE_URI = "http://blumm.com/producing-ws";

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeEndpoint(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getEmployeeRequest")
    @ResponsePayload
    public GetEmployeeResponse getEmployeeResponse(@RequestPayload GetEmployeeRequest getEmployeeRequest) {
        GetEmployeeResponse response = new GetEmployeeResponse();
        response.setEmployee(employeeRepository.findEmployeeByName(getEmployeeRequest.getName()));
        return response;
    }
}
