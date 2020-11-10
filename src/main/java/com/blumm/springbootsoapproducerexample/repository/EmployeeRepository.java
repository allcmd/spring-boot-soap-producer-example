package com.blumm.springbootsoapproducerexample.repository;

import com.blumm.producing_ws.Designation;
import com.blumm.producing_ws.Employee;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeRepository {
    private static final Map<String, Employee> employeeMap = new HashMap<>();

    @PostConstruct
    public void initData() {
        Employee jdoe = new Employee();
        jdoe.setName("Jane");
        jdoe.setSurname("Doe");
        jdoe.setDesignation(Designation.PROGRAMMER);

        Employee acooper = new Employee();
        acooper.setName("Alice");
        acooper.setSurname("Cooper");
        acooper.setDesignation(Designation.ANALYST);

        Employee whouston = new Employee();
        whouston.setName("Whitney");
        whouston.setSurname("Houston");
        whouston.setDesignation(Designation.PROJECT_MANAGER);

        employeeMap.put(jdoe.getName(), jdoe);
        employeeMap.put(acooper.getName(), acooper);
        employeeMap.put(whouston.getName(), whouston);
    }

    public Employee findEmployeeByName(String name) {
        return employeeMap.get(name);
    }
}
