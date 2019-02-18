package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Session;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(final IServiceLocator serviceLocate){
        super(serviceLocate);
    };

    public String command(){
        return "pr c";
    }

    public void execute(){
        System.out.println("enter name project: ");
        final String nameProject = serviceLocator.getConsoleServiceString();
//        System.out.println("enter description project: ");
//        final String descriptionProject = serviceLocator.getConsoleServiceString();

        final Session session = serviceLocator.getSession();
        serviceLocator.getProjectEndpoint().createProject(session, nameProject, "test");
    }

    public String description(){
        return "Create project";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
