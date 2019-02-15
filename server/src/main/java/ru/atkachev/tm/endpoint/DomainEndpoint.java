package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.service.DomainService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.IOException;

@WebService
public class DomainEndpoint {
    final private DomainService domainService;
    public DomainEndpoint(DomainService domainService){
        this.domainService = domainService;
    }

    @WebMethod
    public void xmlSave()throws IOException {
        domainService.xmlSave() ;
    }

    @WebMethod
    public void xmlLoad() throws IOException {
        domainService.xmlLoad();
    }

    @WebMethod
    public void xmlClean() throws IOException {
        domainService.xmlClean();
    }

    @WebMethod
    public void jsonSave() throws IOException {
        domainService.jsonSave();
    }

    @WebMethod
    public void jsonLoad() throws IOException {
        domainService.jsonLoad();
    }

    @WebMethod
    public void jsonClean() throws IOException {
        domainService.jsonClean();
    }
    @WebMethod
    public void binSave() throws IOException {
        domainService.binSave();
    }
    @WebMethod
    public void binLoad() throws IOException, ClassNotFoundException {
        domainService.binLoad();
    }
}
