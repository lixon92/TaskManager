package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Project;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository {

    final private Map<String, Project> projectMap = new HashMap<>();

    public void createProject(final String userId, final String name, final String description){
        final Project project = new Project();
        project.setUserId(userId);
        project.setName(name);
        project.setDescribe(description);
        projectMap.put(project.getId(), project);
    }

    public void deleteProject(final String projectId){
        projectMap.remove(projectId);
    }

    public void updateProject(final String projectId, final String name, final String description ){
        projectMap.get(projectId).setName(name);
        projectMap.get(projectId).setDescribe(description);
    }

    public Collection<Project> getProjectList(){
        return projectMap.values();
    }

    public Project getProjectById(final String projectId){
        return projectMap.get(projectId);
    }

    public void setProjectList(final Collection<Project> projectList) {
        for (final Project project : projectList) {
            projectMap.put(project.getId(), project);
        }
    }
}
