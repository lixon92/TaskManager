package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.service.DomainService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class DomainEndpoint {
    final private DomainService domainService;
    public DomainEndpoint(DomainService domainService){
        this.domainService = domainService;
    }

    @WebMethod
    public void xmlSave() {
        domainService.xmlSave();
    }
    @WebMethod
    public void xmlLoad() {
        domainService.xmlLoad();
    }
}
