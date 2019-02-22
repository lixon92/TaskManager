package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Session;

public class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand(final IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "t u";
    }

    @Override
    public void execute() {

//        System.out.println("enter ID task");
//        final String taskID = serviceLocator.getConsoleServiceString();
//
//        System.out.println("enter new name task: ");
//        final String nameTask = serviceLocator.getConsoleServiceString();
////        System.out.println("enter new description task: ");
////        final String descriptionTask = serviceLocator.getConsoleServiceString();
//        final Session session = serviceLocator.getSession();
//        serviceLocator.getTaskEndpoint().updateTask(session, taskID, nameTask, "test");
    }

    @Override
    public String description() {
        return "Update task";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
