package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;

public class TaskPrintCommand  extends AbstractCommand {

    public TaskPrintCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "t p";
    }

    public void execute() {
        String tasks = serviceLocator.getTaskEndpoint().getTaskList();
        System.out.println(tasks);
    }

    public String description() {
        return "Print tasks";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
