package ru.atkachev.tm;

import sun.rmi.server.InactiveGroupException;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class TestWebService {
    @WebMethod
    public Integer sum(
            @WebParam(name = "a") Integer a,
            @WebParam(name = "b") Integer b){
        return a + b;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/TestWebService?wsdl", new TestWebService());
    }
}
