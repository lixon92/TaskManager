package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectRepository {

    private List<Project> projectList = new ArrayList<>();

    public void createProject(String name, String description){
        final Project project = new Project();
        project.setName(name);
        project.setDescribe(description);
        projectList.add(project);
    }

    public void deleteProject(int index){
        projectList.remove(index);
    }

    public void updateProject( int index, String name, String description ){
        final Project project = projectList.get(index);
        project.setName(name);
        project.setDescribe(description);
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList){
        this.projectList = projectList;
    }
}
