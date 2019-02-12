package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class TaskUpdateCommand extends AbstractCommand {

    public TaskUpdateCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "t u";
    }

    @Override
    public void execute() {
//        int index;
//        String nameTask, descriptionTask;
//
//        System.out.println("enter number task");
//        index = Integer.parseInt(serviceLocator.getTerminalService()) - 1;
//
//        System.out.println("enter new name task: ");
//        nameTask = serviceLocator.getTerminalService();
//
//        System.out.println("enter new description task: ");
//        descriptionTask = serviceLocator.getTerminalService();
//
//        serviceLocator.getTaskService().updateTask(index, nameTask, descriptionTask);
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
