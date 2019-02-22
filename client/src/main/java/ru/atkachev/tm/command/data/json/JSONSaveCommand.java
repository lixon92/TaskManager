package ru.atkachev.tm.command.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.IOException_Exception;
//import ru.atkachev.tm.entity.Project;

import java.io.File;
import java.io.IOException;

public class JSONSaveCommand extends AbstractCommand {

    public JSONSaveCommand(final IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "s j";
    }

    @Override
    public void execute() {
//        try {
//            serviceLocator.getDomainEndpoint().jsonSave();
//        } catch (IOException_Exception e) {
//            System.out.println("Error save!");
//        }
    }

    @Override
    public String description() {
        return "save in json";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
