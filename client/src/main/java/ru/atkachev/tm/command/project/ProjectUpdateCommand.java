package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Session;

public class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand(final IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command(){
        return "pr u";
    }

    @Override
    public void execute(){
//        String nameProject, descriptionProject;
//        System.out.println("enter id project");
//        final String projectId = serviceLocator.getConsoleServiceString();
//
//        System.out.println("enter new name project: ");
//        nameProject = serviceLocator.getConsoleServiceString();
//
////        System.out.println("enter new description project: ");
////        descriptionProject = serviceLocator.getConsoleServiceString();
//
//        final Session session = serviceLocator.getSession();
//        serviceLocator.getProjectEndpoint().updateProject(session, projectId, nameProject, "test");
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
