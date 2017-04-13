package com.jmpprogram.rest;

import com.jmpprogram.EmployeeBunch;
import com.jmpprogram.entity.Employee;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Path("/employee")
public class EmployeeResource {
    public static final String EMPTY_STRING = "";
    private static Map<String, EmployeeBunch> bunches = new HashMap<>();

    /**
     * Creates a new {@link EmployeeBunch}.
     *
     * @return Returns an Id of new {@link EmployeeBunch}.
     */
    @POST
    @Path("/bunch")
    public Response createBunch() {
        EmployeeResourceResponse employeeResourceResponse = new EmployeeResourceResponse();
        try {
            String randomId = String.valueOf(UUID.randomUUID()).replace("-", "");
            bunches.put(randomId, new EmployeeBunch(randomId));
            employeeResourceResponse.setError(EMPTY_STRING);
            employeeResourceResponse.setBody(randomId);
        } catch (Exception e) {
            employeeResourceResponse.setError(e.getMessage());
            employeeResourceResponse.setBody(EMPTY_STRING);
        }
        return Response.status(200).entity(employeeResourceResponse).build();
    }

    @POST
    @Path("/bunch/{bunchId}/job")
    public Response runJob(@PathParam("bunchId") final String bunchId) {
        EmployeeResourceResponse employeeResourceResponse = new EmployeeResourceResponse();
        try {
            EmployeeBunch.BunchJob bunchJob = bunches.get(bunchId).doJob();
            employeeResourceResponse.setError(EMPTY_STRING);
            employeeResourceResponse.setBody(bunchJob.getId());
        } catch (Exception e) {
            employeeResourceResponse.setError(e.getMessage());
            employeeResourceResponse.setBody(EMPTY_STRING);
        }
        return Response.status(200).entity(employeeResourceResponse).build();
    }

    /**
     * Creates a new {@link EmployeeBunch}.
     *
     * @return Returns an Id of new {@link EmployeeBunch}.
     */
    @POST
    @Path("/bunch/{bunchId}")
    public Response addEmployeeToBunch(@PathParam("bunchId") final String bunchId, final Employee employee) {
        EmployeeResourceResponse employeeResourceResponse = new EmployeeResourceResponse();
        try {
            bunches.get(bunchId).addEmployee(employee);
            employeeResourceResponse.setError(EMPTY_STRING);
            employeeResourceResponse.setBody(employee.getEmpId());
        } catch (Exception e) {
            employeeResourceResponse.setError(e.getMessage());
            employeeResourceResponse.setBody(EMPTY_STRING);
        }
        return Response.status(200).entity(employeeResourceResponse).build();
    }
}
