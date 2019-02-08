package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class TaskDeleteCommand extends AbstractCommand {

    public TaskDeleteCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "t d";
    }

    @Override
    public void execute() {
//        int index;
//        System.out.print("enter number of task: ");
//        index = Integer.parseInt(serviceLocate.getTerminalService()) - 1;
//        serviceLocate.getTaskService().deleteTask(index);
    }

    @Override
    public String description() {
        return "Delete selected task";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
