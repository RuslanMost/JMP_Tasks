package com.jmpprogram.rest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmployeeResourceResponse {
    private String error;
    private String body;

    public String getError() {
        return error;
    }

    public void setError(final String error) {
        this.error = error;
    }

    public String getBody() {
        return body;
    }

    public void setBody(final String body) {
        this.body = body;
    }
}
