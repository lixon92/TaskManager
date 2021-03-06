package ru.atkachev.tm.command.data.xml;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.IOException_Exception;

public class XMLLoadCommand extends AbstractCommand {
    public XMLLoadCommand(final IServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "l x";
    }

    @Override
    public void execute() {
        try {
            serviceLocator.getDomainEndpoint().xmlLoad();
        } catch (IOException_Exception e) {
            System.out.println("Error load!");
        }
    }

    @Override
    public String description() {
        return "Load serialise";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
