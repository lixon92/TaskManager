package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.repository.TaskRepository;

import java.util.List;

public class TaskService {

    final private TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public void createTask(String projectId, String name, String description) {
        taskRepository.createTask(projectId, name, description);
    }

    public void deleteTask(String taskId) {
        taskRepository.deleteTask(taskId);
    }

    public void updateTask(String taskId, String name, String description) {
        taskRepository.updateTask(taskId, name, description);
    }

    public String getTaskList() {
        return taskRepository.getTaskList();
    }

    public void setTaskList(List<Task> taskList) {
        taskRepository.setTaskList(taskList);
    }

    public Task getTaskById(String taskId) {
        return taskRepository.getTaskById(taskId);
    }
}
