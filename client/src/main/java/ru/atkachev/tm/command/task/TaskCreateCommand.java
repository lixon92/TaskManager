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
        System.out.println("enter id of project");
        final String projectId = serviceLocator.getConsoleServiceString();

        System.out.println("enter name of task");
        final String nameTask = serviceLocator.getConsoleServiceString();

        System.out.println("enter description of task");
        final String descriptionTask = serviceLocator.getConsoleServiceString();

        serviceLocator.getTaskEndpoint().createTask(projectId, nameTask, descriptionTask);
    }

    public String description() {
        return "Create task";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
