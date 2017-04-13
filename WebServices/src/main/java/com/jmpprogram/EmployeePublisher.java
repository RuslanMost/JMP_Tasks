package com.jmpprogram;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class EmployeePublisher {

    public static void main(String[] args) {
        Endpoint.publish("  http://localhost:8082/employee", new HelloEmployeeImpl());
    }

}
