package ru.atkachev.tm.repository;

import lombok.NoArgsConstructor;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class ProjectRepository {

    private EntityManager em;

    public ProjectRepository(EntityManager em){
        this.em = em;
    }

    public void begin(){
        em.getTransaction().begin();
    }
    public void commit(){
        em.getTransaction().commit();
    }
    public void close(){
        em.close();
    }

    public Project createProject(
            User user,
            final String name,
            final String description
    ){
        final Project project = new Project();
        project.setUser(user);
        project.setName(name);
        project.setDescription(description);
        em.persist(project);
        return project;
    }

    public Project getProjectById(final String projectId){
        return em.find(Project.class, projectId);
    }

    public Collection<Project> getProjectList(){
        final TypedQuery<Project> namedQuery =
                em.createNamedQuery("getAllProjects", Project.class);
        return namedQuery.getResultList();
    }

    public Project updateProject(
            final String projectId,
            final String name,
            final String description
    ){
        Project project = new Project();
        project.setId(projectId);
        project.setName(name);
        project.setDescription(description);
        em.merge(project);
        return project;
    }

    public void setProjectList(final Collection<Project> projectList) {
        em.merge(projectList);
    }

    public void deleteProject(final String projectId){
        final Project project = new Project();
        project.setId(projectId);
        em.remove(em.find(Project.class, projectId));
    }
}
