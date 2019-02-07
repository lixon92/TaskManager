package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;

import java.util.List;

public class ProjectService {

    final private ProjectRepository projectRepository;
    final private TaskRepository taskRepository;

    public ProjectService(ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public void createProject(String name, String description) {
        projectRepository.createProject(name, description);
    }

    public void updateProject(int index, String name, String description) {
        projectRepository.updateProject(index, name, description);
    }

    public void deleteProject(int index) {
        projectRepository.deleteProject(index);
    }

    public List<Project> getProjectList() {
        return projectRepository.getProjectList();
    }

    public void setProjectList(List<Project> projectList) {
        projectRepository.setProjectList(projectList);
    }
}
