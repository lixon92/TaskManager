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
        index = Integer.parseInt(serviceLocate.getTerminalService()) - 1;
        serviceLocate.getProjectService().deleteProject(index);
    }

    public String description() {
        return "Delete project";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
