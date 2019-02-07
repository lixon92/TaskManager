package ru.atkachev.tm.api;

import java.util.Map;

public interface IServiceLocator {

    public abstract ProjectService getProjectService();
    public abstract TaskService getTaskService();
    public abstract String getTerminalService();
    public abstract UserService getUserService();
    public abstract Map<String, AbstractCommand> getCommandList();
    public abstract void setCurrentUser(User currentUser);
    public User getCurrentUser();
}
