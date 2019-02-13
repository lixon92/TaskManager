package ru.atkachev.tm.command.data.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
//import ru.atkachev.tm.entity.Project;

import java.io.File;
import java.io.IOException;

public class XMLSaveCommand extends AbstractCommand {
    public XMLSaveCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "s x";
    }

    @Override
    public void execute(){
        serviceLocator.getDomainEndpoint().xmlSave();
    }

    @Override
    public String description() {
        return "save xml";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
