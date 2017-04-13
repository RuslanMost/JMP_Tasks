package com.jmpprogram;

import com.jmpprogram.entity.Employee;
import com.jmpprogram.rest.EmployeeResourceResponse;
import org.xml.sax.InputSource;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

public class RestClientEmployee {
    public static String createEmployeeBunch() {
        HttpURLConnection conn = null;
        EmployeeResourceResponse response;
        try {
            conn = createConnection(new URL("http://localhost:8080/rest/employee/bunch/"), "POST", MediaType.APPLICATION_XML);
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            response = getResponse(conn);
            checkResponse(response);
        } catch (Exception e) {
            try {
                Optional.ofNullable(conn).ifPresent(HttpURLConnection::disconnect);
            } catch (Exception re) {
                e.addSuppressed(re);
            }
            try {
                throw e;
            } catch (IOException ie) {
                throw new RuntimeException(ie);
            }
        }
        conn.disconnect();
        return response.getBody();
    }

    public static String runBunchJob(String bunchId) {
        HttpURLConnection conn = null;
        EmployeeResourceResponse response;
        try {
            conn = createConnection(new URL("http://localhost:8080/rest/employee/bunch/"+ bunchId  + "/job"), "POST", MediaType.APPLICATION_XML);

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            response = getResponse(conn);
            checkResponse(response);
        } catch (Exception e) {
            try {
                Optional.ofNullable(conn).ifPresent(HttpURLConnection::disconnect);
            } catch (Exception re) {
                e.addSuppressed(re);
            }
            try {
                throw e;
            } catch (IOException ie) {
                throw new RuntimeException(ie);
            }
        }
        conn.disconnect();
        return response.getBody();
    }

    public static String addEmployeeToBunch(final Employee employee, final String bunchId) {
        HttpURLConnection conn = null;
        EmployeeResourceResponse response;
        try {
            conn = createConnection(new URL("http://localhost:8080/rest/employee/bunch/" + bunchId), "POST", MediaType.APPLICATION_XML);

            String input = createXMLEmployee(employee, bunchId);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(input.getBytes());
                os.flush();
            }
            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            response = getResponse(conn);
            checkResponse(response);
        } catch (Exception e) {
            try {
                Optional.ofNullable(conn).ifPresent(HttpURLConnection::disconnect);
            } catch (Exception re) {
                e.addSuppressed(re);
            }
            try {
                throw e;
            } catch (IOException ie) {
                throw new RuntimeException(ie);
            }
        }
        conn.disconnect();
        return response.getBody();
    }

    private static void checkResponse(final EmployeeResourceResponse response) {
        if (response == null || response.getError() == null || response.getBody() == null) {
            throw new IllegalStateException("Could not get valid response.");
        }
        if (!response.getError().isEmpty()) {
            throw new RuntimeException("Detected error on REST server: " + response.getError());
        }
    }

    private static String createXMLEmployee(final Employee employee, final String bunchId) {
        return "<employee>"
                + "<address>" + employee.getAddress() + "</address>"
                + "<department>" + employee.getDepartment() + "</department>"
                + "<empId>" + employee.getEmpId() + "</empId>"
                + "<name>" + employee.getName() + "</name>"
                + "<telNo>" + employee.getTelNo() + "</telNo>"
                + "</employee>";
    }

    private static HttpURLConnection createConnection(final URL url, final String method, final String accept) {
        try {
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod(method);
            conn.setRequestProperty("Accept", accept);
            conn.setRequestProperty("Content-Type", MediaType.APPLICATION_XML);
            return conn;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static EmployeeResourceResponse getResponse(final HttpURLConnection conn) {
        System.out.println("Output from Server .... \n");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeResourceResponse.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            return unmarshaller
                    .unmarshal(
                            new SAXSource(
                                    new InputSource(
                                            conn.getInputStream())), EmployeeResourceResponse.class)
                    .getValue();
        } catch (JAXBException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
