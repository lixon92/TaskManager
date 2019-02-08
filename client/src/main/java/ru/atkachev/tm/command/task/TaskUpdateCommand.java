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
//        index = Integer.parseInt(serviceLocate.getTerminalService()) - 1;
//
//        System.out.println("enter new name task: ");
//        nameTask = serviceLocate.getTerminalService();
//
//        System.out.println("enter new description task: ");
//        descriptionTask = serviceLocate.getTerminalService();
//
//        serviceLocate.getTaskService().updateTask(index, nameTask, descriptionTask);
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
