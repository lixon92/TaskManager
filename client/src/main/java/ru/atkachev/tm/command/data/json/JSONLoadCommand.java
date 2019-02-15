package ru.atkachev.tm.command.data.json;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.IOException_Exception;

public class JSONLoadCommand extends AbstractCommand {
    public JSONLoadCommand(IServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "l j";
    }

    @Override
    public void execute() {
        try {
            serviceLocator.getDomainEndpoint().jsonLoad();
        } catch (IOException_Exception e) {
            System.out.println("Error load!");
        }
    }

    @Override
    public String description() {
        return "load json";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
