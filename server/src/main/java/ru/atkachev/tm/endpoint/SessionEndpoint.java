package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.service.SessionService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class SessionEndpoint {
    final private SessionService sessionService;
    public SessionEndpoint(SessionService sessionService){
        this.sessionService = sessionService;
    }
    @WebMethod
    public Session sessionStart(
            @WebParam(name = "login") String login,
            @WebParam(name = "password")String password
    ) {
        return sessionService.sessionStart(login, password);
    }
}
