package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "t c";
    }

    public void execute() {
        System.out.println("enter number of project");
        final int numberTask = Integer.parseInt(serviceLocate.getTerminalService()) - 1;
        final String projectId = serviceLocate.getProjectService().getProjectList().get(numberTask).getId();

        System.out.println("enter name of task");
        final String nameTask = serviceLocate.getTerminalService();

        System.out.println("enter description of task");
        final String descriptionTask = serviceLocate.getTerminalService();
        serviceLocate.getTaskService().createTask(projectId, nameTask, descriptionTask);
    }

    public String description() {
        return "Create task";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
