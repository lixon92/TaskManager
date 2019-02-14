package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository {

    final private Map<String, Task> taskMap = new HashMap<>();

    public void createTask(String userID, String projectId, String name, String description){
        final Task task = new Task();
        task.setUserID(userID);
        task.setProjectId(projectId);
        task.setName(name);
        task.setDescribe(description);
        taskMap.put(task.getId(), task);
    }

    public void deleteTask(String taskId){
        taskMap.remove(taskId);
    }

    public void updateTask(String taskId, String name, String description){
        taskMap.get(taskId).setName(name);
        taskMap.get(taskId).setDescribe(description);
    }

    public void setTaskList(Collection<Task> taskList) {
        for (Task task : taskList) {
            taskMap.put(task.getId(), task);
        }
    }

    public Task getTaskById(String taskId){
        return taskMap.get(taskId);
    }

    public Collection<Task> getTaskList() {
        return taskMap.values();
    }
}
