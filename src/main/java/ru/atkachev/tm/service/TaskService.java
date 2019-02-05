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

    public void deleteTask(int index) {
        taskRepository.deleteTask(index);
    }

    public void updateTask(int index, String name, String description){
        taskRepository.updateTask(index, name, description);
    }

    public List<Task> getTaskList() {
        return taskRepository.getTaskList();
    }
}
