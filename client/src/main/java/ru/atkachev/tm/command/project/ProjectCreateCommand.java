package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(IServiceLocator serviceLocate){
        super(serviceLocate);
    };

    public String command(){
        return "pr c";
    }

    public void execute(){
        String nameProject, descriptionProject;
        System.out.println("enter name project: ");
        nameProject = serviceLocate.getTerminalService();
        System.out.println("enter description project: ");
        descriptionProject = serviceLocate.getTerminalService();
        serviceLocate.getProjectService().createProject(nameProject, descriptionProject);
    }

    public String description(){
        return "Create project";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
