package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Session;

public class ProjectDeleteCommand extends AbstractCommand {

    public ProjectDeleteCommand(IServiceLocator serviceLocate) {

        super(serviceLocate);

    }

    public String command() {
        return "pr d";
    }

    public void execute() {
        final Session session = serviceLocator.getSession();

        System.out.print("enter number of project: ");
        final String projectId = serviceLocator.getConsoleServiceString();

        try {
            serviceLocator.getProjectEndpoint().deleteProject(session, projectId);
        }catch (ru.atkachev.tm.endpoint.IOException_Exception e) {
            System.out.println("Project didn't found");
        }
    }

    public String description() {
        return "Delete project";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
