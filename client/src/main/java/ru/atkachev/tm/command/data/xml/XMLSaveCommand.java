package ru.atkachev.tm.command.data.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.entity.Project;

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
        Project[] projects = serviceLocate.getProjectService().getProjectList().toArray(new Project[0]);
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("temp.xml");
        try {
            xmlMapper.writeValue(file, projects);
        } catch (IOException e){
            System.out.println("IOException!!!");
        }
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
