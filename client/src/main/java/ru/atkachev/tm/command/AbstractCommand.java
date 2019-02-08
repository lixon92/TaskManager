package ru.atkachev.tm.command;

import ru.atkachev.tm.api.IServiceLocator;

public abstract class AbstractCommand {

    final protected IServiceLocator serviceLocate;

    public AbstractCommand(IServiceLocator serviceLocate){
        this.serviceLocate = serviceLocate;
    };
    public abstract String command();
    public abstract void execute();
    public abstract String description();
    public abstract boolean isSecure();

}
