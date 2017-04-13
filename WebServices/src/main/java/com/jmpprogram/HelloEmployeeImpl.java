package com.jmpprogram;

import com.jmpprogram.entity.Employee;

import javax.jws.WebService;

//Service Implementation
@WebService(endpointInterface = "com.jmpprogram.HelloEmployee")
public class HelloEmployeeImpl implements HelloEmployee {
    @Override
    public boolean createEmployeeBunch(final Employee[] employees) {
        String bunchId = RestClientEmployee.createEmployeeBunch();
        System.out.println("Bunch with id " + bunchId + " was created.");
        for (Employee employee : employees) {
            String employeeId = RestClientEmployee.addEmployeeToBunch(employee, bunchId);
            System.out.println("Employee with id " + employeeId + " was created.");
        }
        String jobId = RestClientEmployee.runBunchJob(bunchId);
        System.out.println("Job with id " + jobId + " was created.");
        return true;
    }
}
