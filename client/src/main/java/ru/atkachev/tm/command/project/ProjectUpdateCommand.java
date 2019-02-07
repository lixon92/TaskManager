package ru.atkachev.tm.command.project;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class ProjectUpdateCommand extends AbstractCommand {


    public ProjectUpdateCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "pr u";
    }

    @Override
    public void execute() {
        int index;
        String nameProject, descriptionProject;
        System.out.println("enter number project");
        index = Integer.parseInt(serviceLocate.getTerminalService()) - 1;

        System.out.println("enter new name project: ");
        nameProject = serviceLocate.getTerminalService();

        System.out.println("enter new description project: ");
        descriptionProject = serviceLocate.getTerminalService();

        serviceLocate.getProjectService().updateProject(index, nameProject, descriptionProject);
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
