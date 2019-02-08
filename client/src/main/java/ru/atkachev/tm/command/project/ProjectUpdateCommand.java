package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class ProjectUpdateCommand extends AbstractCommand {


    public ProjectUpdateCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command(){
        return "pr u";
    }

    @Override
    public void execute(){
        String nameProject, descriptionProject;
        System.out.println("enter id project");
        final String projectId = serviceLocate.getConsoleServiceString();

        System.out.println("enter new name project: ");
        nameProject = serviceLocate.getConsoleServiceString();

        System.out.println("enter new description project: ");
        descriptionProject = serviceLocate.getConsoleServiceString();

        serviceLocate.getProjectEndpoint().updateProject(projectId, nameProject, descriptionProject);
    }

    @Override
    public String description() {
        return "Update project";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
