package ru.atkachev.tm.repository;

import lombok.NoArgsConstructor;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.User;
import javax.persistence.EntityManager;
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

    final private Map<String, Project> projectMap = new HashMap<>();

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

    public Project getProjectById(String projectId){
        return em.find(Project.class, projectId);
    }




    public void deleteProject(final String projectId){
        projectMap.remove(projectId);
    }

    public void updateProject(final String projectId, final String name, final String description ){
        projectMap.get(projectId).setName(name);
        projectMap.get(projectId).setDescription(description);
    }

    public Collection<Project> getProjectList(){
        return projectMap.values();
    }
//    public Project getProjectById(final String projectId){
//        return projectMap.get(projectId);

//    }

    public void setProjectList(final Collection<Project> projectList) {
        for (final Project project : projectList) {
            projectMap.put(project.getId(), project);
        }
    }
}
