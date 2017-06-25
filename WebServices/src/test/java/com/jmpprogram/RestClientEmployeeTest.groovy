package com.jmpprogram

import com.jmpprogram.rest.EmployeeResourceResponse
import spock.lang.Specification

class RestClientEmployeeTest extends Specification {
    def connection = Mock(HttpURLConnection)
    def response = Mock(EmployeeResourceResponse)
    def "test createEmployeeBunch"() {
        given:
        def employee = GroovySpy(RestClientEmployee, global: true)

        response.getBody() >> "SomeTestResponse"
        employee.createConnection(_ as URL, _ as String, _ as String) >> connection
        connection.getResponseCode() >> HttpURLConnection.HTTP_OK
        employee.getResponse(connection) >> response
        response.getError() >> ""

        when:
        def bunch = employee.createEmployeeBunch()
        then:
        assert bunch == "SomeTestResponse"
    }
}
