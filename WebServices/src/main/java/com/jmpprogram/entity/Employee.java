package com.jmpprogram.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")
public class Employee {

    private String empId;
    private String name;
    private String department;
    private String address;
    private String telNo;

    public Employee() {
    }

    public Employee(final String name) {
        this.name = name;
    }

    /**
     * Bean Employee.
     *
     * @param empId      Id of an employee.
     * @param name       Name of an employee.
     * @param department Department of an employee.
     * @param address    Address of an employee.
     * @param telNo      Telephone number of an employee.
     */
    public Employee(final String empId, final String name, final String department, final String address, final String telNo) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.address = address;
        this.telNo = telNo;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId='" + empId + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", address='" + address + '\'' +
                ", telNo='" + telNo + '\'' +
                '}';
    }
}