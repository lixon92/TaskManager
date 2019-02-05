package ru.atkachev.tm.command.helper;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.command.AbstractCommand;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.entity.User;

import java.util.List;

public class Helper extends AbstractCommand {
    public Helper(IServiceLocator serviceLocate) {
        super(serviceLocate);
    }

    @Override
    public String command() {
        return "f";
    }

    @Override
    public void execute() {

        serviceLocate.getUserService().createUser("f", "Alex", "", "f");
        final User user = serviceLocate.getUserService().findUser("f", "f");
        serviceLocate.setCurrentUser(user);

        serviceLocate.getProjectService().createProject("Project_test1", "");
        serviceLocate.getProjectService().createProject("Project_test2", "");

        serviceLocate.getTaskService().createTask("", "Task_test1", "");
        serviceLocate.getTaskService().createTask("", "Task_test2", "");

        List<Project> projects = serviceLocate.getProjectService().getProjectList();

        for ( int i = 0; i < projects.size(); i++ ){
            System.out.println( i + 1 + ". " + projects.get(i).getName() + " " + projects.get(i).getId());
        }

        List<Task> taskList = serviceLocate.getTaskService().getTaskList();

        int index = 0;
        for (Task task : taskList){
            System.out.println(index + 1 + ". " + task.getName() + " " + task.getId());
            index++;
        }
    }

    @Override
    public String description() {
        return "Create test cases";
    }

    @Override
    public boolean isSecure() {
        return false;
    }
}
