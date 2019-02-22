package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.IOException;
import ru.atkachev.tm.endpoint.Session;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(final IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "t c";
    }

    public void execute() {
//        System.out.println("enter id of project");
//        final String projectId = serviceLocator.getConsoleServiceString();
//
//        System.out.println("enter name of task");
//        final String nameTask = serviceLocator.getConsoleServiceString();
////        System.out.println("enter description of task");
////        final String descriptionTask = serviceLocator.getConsoleServiceString();
//        final Session session = serviceLocator.getSession();
//
//        try{
//            serviceLocator.getTaskEndpoint().createTask( session,projectId, nameTask, "test");
//        }catch (ru.atkachev.tm.endpoint.IOException_Exception e){
//            System.out.println("Проект не найден");
//        }
    }

    public String description() {
        return "Create task";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
