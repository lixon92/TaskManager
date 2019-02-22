package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Session;

public class TaskDeleteCommand extends AbstractCommand {

    public TaskDeleteCommand(final IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "t d";
    }

    @Override
    public void execute(){
//        final Session session = serviceLocator.getSession();
//
//        System.out.print("enter id of task: ");
//        final String taskId = serviceLocator.getConsoleServiceString();
//
//        try{
//            serviceLocator.getTaskEndpoint().deleteTask(session, taskId);
//        } catch (ru.atkachev.tm.endpoint.IOException_Exception e){
//            System.out.println("Задача не найдена.");
//        }
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
