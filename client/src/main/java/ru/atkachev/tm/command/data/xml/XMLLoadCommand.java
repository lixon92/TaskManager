package ru.atkachev.tm.command.data.xml;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class XMLLoadCommand extends AbstractCommand {
    public XMLLoadCommand(IServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "l x";
    }

    @Override
    public void execute() {
        serviceLocator.getDomainEndpoint().xmlLoad();
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
