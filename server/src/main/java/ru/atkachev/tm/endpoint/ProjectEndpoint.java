package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.service.ProjectService;
import ru.atkachev.tm.util.ValidateSession;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Collection;
import java.util.List;

@WebService
public class ProjectEndpoint {
    final private ProjectService projectService;

    public ProjectEndpoint(ProjectService projectService){
        this.projectService = projectService;
    }

    @WebMethod
    public Project getProjectById(
        @WebParam(name = "session") Session session,
        @WebParam(name = "projectId") String projectId
    ) {
        ValidateSession.validate(session);
        return projectService.getProjectById(projectId);
    }

    @WebMethod
    public void createProject(
        @WebParam(name = "session") Session session,
        @WebParam(name = "name")String name,
        @WebParam(name = "description")String description
    ) {
        ValidateSession.validate(session);
        projectService.createProject(session.getUserId(), name, description);
    }

    @WebMethod
    public void updateProject(
        @WebParam(name = "session") Session session,
        @WebParam(name = "projectId")String projectId,
        @WebParam(name = "name")String name,
        @WebParam(name = "description")String description
    ) {
        ValidateSession.validate(session);
        projectService.updateProject(projectId, name, description);
    }

    @WebMethod
    public void deleteProject(
        @WebParam(name = "session") Session session,
        @WebParam(name = "projectId")String projectId
    ) {
        ValidateSession.validate(session);
        projectService.deleteProject(projectId);
    }

    @WebMethod
    public Collection<Project> getProjectList(
        @WebParam(name = "session") Session session
    ) {
        ValidateSession.validate(session);
        return projectService.getProjectList();
    }

    @WebMethod
    public void setProjectList(
        @WebParam(name = "session") Session session,
        @WebParam(name = "projectList")List<Project> projectList
    ) {
        ValidateSession.validate(session);
        projectService.setProjectList(projectList);
    }
}
