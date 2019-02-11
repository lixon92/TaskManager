package ru.atkachev.tm.api;

import ru.atkachev.tm.endpoint.*;

public interface IServiceLocator {

    ProjectEndpoint getProjectEndpoint();
    TaskEndpoint getTaskEndpoint();
    UserEndpoint getUserEndpoint();
    SessionEndpoint getSessionEndpoint();
    public Session getSession();
    public void setSession(Session session);


    public String getConsoleServiceString();
    public int getConsoleServiceInteger();
    public double getConsoleServiceDouble();
}
