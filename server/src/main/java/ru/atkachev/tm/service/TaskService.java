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

    public TaskService(final TaskRepository taskRepository, final ProjectRepository projectRepository){
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public void createTask(final String userID, final String projectId, final String name, final String description) throws IOException {
        if (projectRepository.getProjectById(projectId) == null) throw new IOException();
        taskRepository.createTask(userID, projectId, name, description);
    }

    public void deleteTask(final String taskId) throws IOException {
        if (taskRepository.getTaskById(taskId) == null) throw new IOException();
        taskRepository.deleteTask(taskId);
    }

    public void updateTask(final String taskId, final String name, final String description) {
        taskRepository.updateTask(taskId, name, description);
    }

    public Collection<Task> getTaskList() {
        return taskRepository.getTaskList();
    }

    public void setTaskList(final Collection<Task> taskList) {
        taskRepository.setTaskList(taskList);
    }

    public Task getTaskById(final String taskId) {
        return taskRepository.getTaskById(taskId);
    }

}
