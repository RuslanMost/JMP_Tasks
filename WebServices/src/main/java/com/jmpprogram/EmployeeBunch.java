package com.jmpprogram;

import com.jmpprogram.entity.Employee;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@XmlRootElement(name = "employeeBunch")
public class EmployeeBunch {
    private String id;
    private ArrayList<Employee> employees = new ArrayList<>();
    private List<BunchJob> jobs = new ArrayList<>();

    public EmployeeBunch() {
    }

    public EmployeeBunch(final String id) {
        this.id = id;
    }

    public boolean addEmployee(final Employee employee) {
        employee.setEmpId(String.valueOf(UUID.randomUUID()).replace("-", ""));
        return employees.add(employee);
    }

    public boolean removeEmployee(final Employee employee) {
        return employees.remove(employee);
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(final ArrayList<Employee> employees) {
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeBunch{" +
                "id='" + id + '\'' +
                ", employees=" + employees +
                '}';
    }

    public BunchJob doJob() {
        jobs.add(new BunchJob(String.valueOf(UUID.randomUUID())));
        return jobs.get(jobs.size() - 1);
    }

    public static class BunchJob {
        private String id;

        public BunchJob(final String s) {
            this.id = s;
        }

        public String getId() {
            return id;
        }

        public void setId(final String id) {
            this.id = id;
        }
    }
}
