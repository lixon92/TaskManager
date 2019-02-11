package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.service.ProjectService;
import ru.atkachev.tm.util.ValidateSession;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProjectEndpoint {
    final private ProjectService projectService;

    public ProjectEndpoint(ProjectService projectService){
        this.projectService = projectService;
    }

    @WebMethod
    public Project getProjectById(
            @WebParam(name = "projectId") String projectId) {
        return projectService.getProjectById(projectId);
    }
    @WebMethod
    public void createProject(
            @WebParam(name = "session") Session session,
            @WebParam(name = "name")String name,
            @WebParam(name = "description")String description) {
        if(ValidateSession.validate(session)){
            projectService.createProject(session.getUserId(), name, description);
        }
        else {
            System.out.println("Session not valid");
        }
    }
    @WebMethod
    public void updateProject(
            @WebParam(name = "projectId")String projectId,
            @WebParam(name = "name")String name,
            @WebParam(name = "description")String description) {
        projectService.updateProject(projectId, name, description);
    }
    @WebMethod
    public void deleteProject(
            @WebParam(name = "projectId")String projectId) {
        projectService.deleteProject(projectId);
    }
    @WebMethod
    public String getProjectList() {
        return projectService.getProjectList();
    }
    @WebMethod
    public void setProjectList(
            @WebParam(name = "projectList")List<Project> projectList) {
        projectService.setProjectList(projectList);
    }
}
