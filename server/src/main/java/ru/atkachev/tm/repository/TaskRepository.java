package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Task;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskRepository {

    final private Map<String, Task> taskMap = new HashMap<>();

    public void createTask(final String userID, final String projectId, final String name, final String description){
        final Task task = new Task();
        task.setUserID(userID);
        task.setProjectId(projectId);
        task.setName(name);
        task.setDescribe(description);
        taskMap.put(task.getId(), task);
    }

    public void deleteTask(final String taskId){
        taskMap.remove(taskId);
    }

    public void updateTask(final String taskId, final String name, final String description){
        taskMap.get(taskId).setName(name);
        taskMap.get(taskId).setDescribe(description);
    }

    public void setTaskList(final Collection<Task> taskList) {
        for (Task task : taskList) {
            taskMap.put(task.getId(), task);
        }
    }

    public Task getTaskById(final String taskId){
        return taskMap.get(taskId);
    }

    public Collection<Task> getTaskList() {
        return taskMap.values();
    }
}
