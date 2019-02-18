package ru.atkachev.tm.command.data.xml;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.IOException_Exception;

public class XMLCleanCommand extends AbstractCommand {
    public XMLCleanCommand(final IServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "c x";
    }

    @Override
    public void execute() {
        try {
            serviceLocator.getDomainEndpoint().xmlClean();
        } catch (IOException_Exception e) {
            System.out.println("Error clean");
        }
    }

    @Override
    public String description() {
        return "clean all";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
