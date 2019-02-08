package ru.atkachev.tm.api;

import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.ProjectEndpoint;
import ru.atkachev.tm.endpoint.TaskEndpoint;

import java.util.Map;

public interface IServiceLocator {

    ProjectEndpoint getProjectEndpoint();
    TaskEndpoint getTaskEndpoint();
    public String getConsoleServiceString();
    public int getConsoleServiceInteger();
    public double getConsoleServiceDouble();
}
