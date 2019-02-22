package ru.atkachev.tm.api;

import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.*;

import java.util.Collection;

public interface IServiceLocator {

    ProjectEndpoint getProjectEndpoint();
//    TaskEndpoint getTaskEndpoint();
    UserEndpoint getUserEndpoint();
    SessionEndpoint getSessionEndpoint();
//    DomainEndpoint getDomainEndpoint();

    Session getSession();
    void setSession(final Session session);

    public Collection<AbstractCommand> getCommandList();
    public String getConsoleServiceString();
    public int getConsoleServiceInteger();
    public double getConsoleServiceDouble();
}
