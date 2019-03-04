package ru.atkachev.tm.repository;

import lombok.NoArgsConstructor;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.entity.User;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    final private Map<String, Task> taskMap = new HashMap<>();

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

    public void deleteTask(final String taskId){
        taskMap.remove(taskId);
    }

    public void updateTask(final String taskId, final String name, final String description){
        taskMap.get(taskId).setName(name);
//        taskMap.get(taskId).setDescription(description);
    }

    public void setTaskList(final Collection<Task> taskList) {
        for (Task task : taskList) {
            taskMap.put(task.getId(), task);
        }
    }

    public Task getTaskById(final String taskId){
        return taskMap.get(taskId);
    }

    public Collection<Task> getTaskList() {
        return taskMap.values();
    }
}
