package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class ProjectDeleteCommand extends AbstractCommand {

    public ProjectDeleteCommand(IServiceLocator serviceLocate) {

        super(serviceLocate);

    }

    public String command() {
        return "pr d";
    }

    public void execute() {
        int index;
        System.out.print("enter number of project: ");
        final String projectId = serviceLocate.getConsoleServiceString();
        serviceLocate.getProjectEndpoint().deleteProject(projectId);
    }

    public String description() {
        return "Delete project";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
