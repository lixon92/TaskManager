package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.service.SessionService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;

@WebService
public class SessionEndpoint {
    final private SessionService sessionService;
    public SessionEndpoint(final SessionService sessionService){
        this.sessionService = sessionService;
    }
    @WebMethod
    public Session sessionStart(
            @WebParam(name = "login") final String login,
            @WebParam(name = "password") final String password
    ) throws IOException {
        return sessionService.sessionStart(login, password);
    }
}
