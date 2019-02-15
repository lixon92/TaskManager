package ru.atkachev.tm.command.data.json;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.IOException_Exception;

public class JSONCleanCommand extends AbstractCommand {
    public JSONCleanCommand(IServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "c j";
    }

    @Override
    public void execute() {
        try {
            serviceLocator.getDomainEndpoint().jsonClean();
        } catch (IOException_Exception e) {
            System.out.println("Error clean!");
        }
    }

    @Override
    public String description() {
        return "clean json";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}