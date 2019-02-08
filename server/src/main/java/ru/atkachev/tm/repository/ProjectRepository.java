package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Project;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProjectRepository {

    final private Map<String, Project> projectMap = new HashMap<>();

    public void createProject(String name, String description){
        final Project project = new Project();
        project.setName(name);
        project.setDescribe(description);
        projectMap.put(project.getId(), project);
    }

    public void deleteProject(String projectId){
        projectMap.remove(projectId);
    }

    public void updateProject( String projectId, String name, String description ){
        projectMap.get(projectId).setName(name);
        projectMap.get(projectId).setDescribe(description);
    }

    public String getProjectList(){
        StringBuilder projectStr = new StringBuilder();
        int count = 1;
        for(Project project : projectMap.values()){
            projectStr.append(count + ". " + project.getName() + " " + project.getId() + "\n");
            count++;
        }
        return projectStr.toString();
    }

    public Project getProjectById(String projectId){
        return projectMap.get(projectId);
    }

    public void setProjectList(List<Project> projectList) {
        for (Project project : projectList) {
            projectMap.put(project.getId(), project);
        }
    }
}
