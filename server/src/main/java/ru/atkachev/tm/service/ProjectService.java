package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;

import java.util.List;

public class ProjectService {

    final private ProjectRepository projectRepository;
    final private TaskRepository taskRepository;

    public Project getProjectById(String projectId) {
        return projectRepository.getProjectById(projectId);
    }

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public void createProject(String name, String description) {
        projectRepository.createProject(name, description);
    }

    public void updateProject(String projectId, String name, String description) {
        projectRepository.updateProject(projectId, name, description);
    }

    public void deleteProject(String projectId) {
        projectRepository.deleteProject(projectId);
    }

    public String getProjectList() {
        return projectRepository.getProjectList();
    }

    public void setProjectList(List<Project> projectList) {
        projectRepository.setProjectList(projectList);
    }
}
