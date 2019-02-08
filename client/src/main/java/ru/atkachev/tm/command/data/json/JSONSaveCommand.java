package ru.atkachev.tm.command.data.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
//import ru.atkachev.tm.entity.Project;

import java.io.File;
import java.io.IOException;

public class JSONSaveCommand extends AbstractCommand {

    public JSONSaveCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "j s";
    }

    @Override
    public void execute() {
//        Project[] projects = serviceLocate.getProjectService().getProjectList().toArray(new Project[0]);
//        ObjectMapper mapper = new ObjectMapper();
//        File file = new File("temp.json");
//        try {
//            mapper.writeValue(file, projects);
//        } catch (IOException e){
//            System.out.println("IOException!!!");
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
