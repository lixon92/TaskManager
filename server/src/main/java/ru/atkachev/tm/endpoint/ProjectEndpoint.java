package ru.atkachev.tm.endpoint;

import lombok.NoArgsConstructor;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.entityDTO.ProjectDTO;
import ru.atkachev.tm.service.ProjectService;
import ru.atkachev.tm.util.ValidateSession;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebService
@NoArgsConstructor
public class ProjectEndpoint {
    private ProjectService projectService;

    public ProjectEndpoint(final ProjectService projectService){
        this.projectService = projectService;
    }

    @WebMethod
    public ProjectDTO getProjectById(
        @WebParam(name = "session") final Session session,
        @WebParam(name = "projectId") final String projectId
    ) {
        ValidateSession.validate(session);
        final Project project = projectService.getProjectById(projectId);
        return ProjectDTO.toDTO(project);
    }

    @WebMethod
    public void createProject(
        @WebParam(name = "session") final Session session,
        @WebParam(name = "name") final String name,
        @WebParam(name = "description") final String description
    ) {
        ValidateSession.validate(session);
        projectService.createProject(session.getUser().getId(), name, description);
    }

    @WebMethod
    public void updateProject(
        @WebParam(name = "session") final Session session,
        @WebParam(name = "projectId") final String projectId,
        @WebParam(name = "name") final String name,
        @WebParam(name = "description") final String description
    ) {
        ValidateSession.validate(session);
        projectService.updateProject(projectId, name, description);
    }

    @WebMethod
    public void deleteProject(
        @WebParam(name = "session") final Session session,
        @WebParam(name = "projectId") final String projectId
    ) throws IOException {
        ValidateSession.validate(session);
        projectService.removeProject(projectId);
    }

    @WebMethod
    public Collection<ProjectDTO> getProjectList(
        @WebParam(name = "session") Session session
    ) {
        ValidateSession.validate(session);
        Collection<Project> projects = projectService.getProjectList();
        return ProjectDTO.toListDTO(projects);
    }

    @WebMethod
    public void setProjectList(
        @WebParam(name = "session") final Session session,
        @WebParam(name = "projectList") final List<Project> projectList
    ) {
        ValidateSession.validate(session);
        projectService.setProjectList(projectList);
    }

}
