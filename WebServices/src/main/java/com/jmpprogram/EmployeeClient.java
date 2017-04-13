package com.jmpprogram;

import com.jmpprogram.entity.Employee;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;

public class EmployeeClient {

    public static void main(final String[] args) throws Exception {

        URL url = new URL("http://localhost:8082/employee?wsdl");

        //1st argument service URI, refer to wsdl document above
        //2nd argument is service name, refer to wsdl document above
        QName qname = new QName("http://jmpprogram.com/", "HelloEmployeeImplService");

        Service service = Service.create(url, qname);

        HelloEmployee hello = service.getPort(HelloEmployee.class);

        Employee[] employees = new Employee[]{new Employee("Richard"), new Employee("Michael"), new Employee("John")};
        System.out.println(hello.createEmployeeBunch(employees));

    }

}
