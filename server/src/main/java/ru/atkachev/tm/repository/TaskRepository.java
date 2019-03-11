package ru.atkachev.tm.repository;

import lombok.NoArgsConstructor;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Collection;

@NoArgsConstructor
public class TaskRepository {

    private EntityManager em;

    public TaskRepository(EntityManager em){
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

    public Task createTask(
            final User user,
            final Project project,
            final String name,
            final String description
    ){
        final Task task = new Task();
        task.setUser(user);
        task.setProject(project);
        task.setName(name);
        task.setDescription(description);
        em.persist(task);
        return task;
    }

    public Task getTaskById(final String taskId){
        return em.find(Task.class, taskId);
    }

    public Collection<Task> getTaskList() {
        final TypedQuery<Task> namedQuery =
                em.createNamedQuery("getAllTasks", Task.class);
        return namedQuery.getResultList();
    }

    public Task updateTask(
            final String taskId,
            final String name,
            final String description
    ){
        Task task = new Task();
        task.setId(taskId);
        task.setName(name);
        task.setDescription(description);
        em.merge(task);
        return task;
    }

    public void setTaskList(final Collection<Task> taskList) {
        em.merge(taskList);
    }

    public void deleteTask(final String taskId){
        final Task task = new Task();
        task.setId(taskId);
        em.remove(em.find(Task.class, taskId));
    }

}
