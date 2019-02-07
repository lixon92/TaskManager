package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.entity.Project;

import java.util.List;

public class ProjectPrintCommand extends AbstractCommand {

    public ProjectPrintCommand(IServiceLocator serviceLocate){
        super(serviceLocate);
    }

    public String command(){
        return "pr p";
    }

    public void execute(){
        List<Project> projects = serviceLocate.getProjectService().getProjectList();

        if (projects.isEmpty()){
            System.out.println("Empty");
        }
        for ( int i = 0; i < projects.size(); i++ ){
            System.out.printf("%s. %s %.8s%n", i + 1, projects.get(i).getName(), projects.get(i).getId());
        }
    }

    public String description(){
        return "Print projects";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
