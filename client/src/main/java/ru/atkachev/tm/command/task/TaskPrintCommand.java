package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.endpoint.Session;
import ru.atkachev.tm.endpoint.Task;
import ru.atkachev.tm.endpoint.TaskDTO;

public class TaskPrintCommand  extends AbstractCommand {

    public TaskPrintCommand(final IServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    @Override
    public String command() {
        return "t p";
    }

    @Override
    public void execute() {

        final Session session = serviceLocator.getSession();
        if (serviceLocator.getTaskEndpoint().getTaskList(session).isEmpty()){
            System.out.println("Empty");
        }

        int index = 1;
        for (final TaskDTO task : serviceLocator.getTaskEndpoint().getTaskList(session) ){
            System.out.printf("%d. %s %s %s%n", index,
                    task.getName(), task.getId(), task.getUserId());
            index++;
        }
    }

    @Override
    public String description() {
        return "Print tasks";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
