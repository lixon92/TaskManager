package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    final private List<Task> taskList = new ArrayList<>();
    private Task task = new Task();

    public void createTask(String projectId, String name, String description){
        task.setProjectId(projectId);
        task.setName(name);
        task.setDescribe(description);
        taskList.add(task);
    }

    public void deleteTask(int index){
        taskList.remove(index);
    }

    public void updateTask(int index, String name, String description){
        task = taskList.get(index);
        task.setName(name);
        task.setDescribe(description);
    }
    public List<Task> getTaskList() {
        return taskList;
    }
}
