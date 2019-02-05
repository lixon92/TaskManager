package ru.atkachev.tm.command.task;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.entity.Task;

import java.util.List;

public class TaskPrintCommand  extends AbstractCommand {

    public TaskPrintCommand(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    public String command() {
        return "t p";
    }

    public void execute() {
        List<Task> taskList = serviceLocate.getTaskService().getTaskList();
        int index = 1;
        for (Task task : taskList){
            System.out.printf("%s. %s %.8s %.8s%n", index, task.getName(), task.getId(), task.getProjectId());
            index++;
        }
        //task = new Task();
    }

    public String description() {
        return "Print tasks";
    }

    @Override
    public boolean isSecure() {
        return true;
    }
}
