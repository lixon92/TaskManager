package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.service.ProjectService;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {
    final private ProjectService projectService;

    public ProjectEndpoint(ProjectService projectService){
        this.projectService = projectService;
    }

    @WebMethod
    public void createProject(String name, String description) {
        projectService.createProject(name, description);
    }

    @WebMethod
    public void updateProject(int index, String name, String description) {
        projectService.updateProject(index, name, description);
    }

    @WebMethod
    public void deleteProject(int index) {
        projectService.deleteProject(index);
    }

    @WebMethod
    public List<Project> getProjectList() {
        return projectService.getProjectList();
    }

    @WebMethod
    public void setProjectList(List<Project> projectList) {
        projectService.setProjectList(projectList);
    }
}
