package ru.atkachev.tm.service;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Role;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.repository.UserRepository;
import ru.atkachev.tm.util.ValidateSession;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static ru.atkachev.tm.util.ValidateSession.validate;

public class ProjectService {

    private IServiceLocator serviceLocator;
    public ProjectService(final IServiceLocator serviceLocator){
        this.serviceLocator = serviceLocator;
    }

    private EntityManager createEntityManager(){
        return serviceLocator.getEntityManagerFactory().createEntityManager();
    }
    private ProjectRepository getProjectRepository(){
        return new ProjectRepository(createEntityManager());
    }
    private UserRepository getUserRepository(){
        return new UserRepository(createEntityManager());
    }

    public Project createProject(
            final String userId,
            final String name,
            final String description
    ) {
        if(userId == null || userId.isEmpty()) return null;
        if(name == null || name.isEmpty()) return null;
        if(description== null || description.isEmpty()) return null;

        UserRepository userRepository = getUserRepository();
        User user = userRepository.getUserById(userId);
        if(user == null) return null;

        ProjectRepository projectRepository = getProjectRepository();
        projectRepository.begin();
        Project project = projectRepository.createProject(user, name, description);
        projectRepository.commit();
        projectRepository.close();
        return project;
    }

    public Project getProjectById(final String projectId) {
        if(projectId == null || projectId.isEmpty()) return null;
        ProjectRepository repository = getProjectRepository();
        return repository.getProjectById(projectId);
    }

    public Collection<Project> getProjectList() {
        ProjectRepository projectRepository = getProjectRepository();
        return projectRepository.getProjectList();
    }

    public Project updateProject(
            final String projectId,
            final String name,
            final String description
    ) {
        ProjectRepository projectRepository = getProjectRepository();
        projectRepository.begin();
        Project project = projectRepository.updateProject(
                projectId,
                name,
                description);
        projectRepository.commit();
        projectRepository.close();
        return project;
    }

    public void setProjectList(final List<Project> projectList) {
        ProjectRepository projectRepository = getProjectRepository();
        projectRepository.begin();
        projectRepository.setProjectList(projectList);
        projectRepository.commit();
        projectRepository.close();
    }

    public void removeProject(final String projectId) throws IOException {
        if(projectId == null || projectId.isEmpty()) return;
        ProjectRepository projectRepository = getProjectRepository();
        projectRepository.begin();
        projectRepository.deleteProject(projectId);
        projectRepository.commit();
        projectRepository.close();
    }
}
