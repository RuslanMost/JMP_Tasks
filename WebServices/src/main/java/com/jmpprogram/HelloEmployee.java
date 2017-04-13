package com.jmpprogram;

import com.jmpprogram.entity.Employee;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloEmployee {

    @WebMethod
    boolean createEmployeeBunch(Employee[] name);
}
