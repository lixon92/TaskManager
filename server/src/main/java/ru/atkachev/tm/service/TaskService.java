package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

public class TaskService {

    final private TaskRepository taskRepository;
    final private ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository){
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public void createTask(String userID, String projectId, String name, String description) throws IOException {
        if (projectRepository.getProjectById(projectId) == null) throw new IOException();
        taskRepository.createTask(userID, projectId, name, description);
    }

    public void deleteTask(String taskId) throws IOException {
        if (taskRepository.getTaskById(taskId) == null) throw new IOException();
        taskRepository.deleteTask(taskId);
    }

    public void updateTask(String taskId, String name, String description) {
        taskRepository.updateTask(taskId, name, description);
    }

    public Collection<Task> getTaskList() {
        return taskRepository.getTaskList();
    }

    public void setTaskList(Collection<Task> taskList) {
        taskRepository.setTaskList(taskList);
    }

    public Task getTaskById(String taskId) {
        return taskRepository.getTaskById(taskId);
    }

}
