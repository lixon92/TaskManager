package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.util.ValidateSession;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static ru.atkachev.tm.util.ValidateSession.validate;

public class ProjectService {

    final private ProjectRepository projectRepository;
    final private TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public Project getProjectById(String projectId) {
        return projectRepository.getProjectById(projectId);
    }

    public void createProject(String userId, String name, String description) {
        projectRepository.createProject(userId, name, description);
    }

    public void updateProject(String projectId, String name, String description) {
        projectRepository.updateProject(projectId, name, description);
    }

    public void deleteProject(String projectId) throws IOException {
        if(projectRepository.getProjectById(projectId) == null) throw new IOException();
        projectRepository.deleteProject(projectId);
    }

    public Collection<Project> getProjectList() {
        return projectRepository.getProjectList();
    }

    public void setProjectList(List<Project> projectList) {
        projectRepository.setProjectList(projectList);
    }
}
