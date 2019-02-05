package ru.atkachev.tm.command.data.xml;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class XMLSaveCommand extends AbstractCommand {
    public XMLSaveCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "save-xml";
    }

    @Override
    public void execute(){

    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
