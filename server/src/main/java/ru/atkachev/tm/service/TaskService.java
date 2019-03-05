package ru.atkachev.tm.service;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.repository.UserRepository;
import javax.persistence.EntityManager;
import java.io.IOException;
import java.util.Collection;

public class TaskService {

    final private IServiceLocator serviceLocator;
    public TaskService(IServiceLocator serviceLocator){
        this.serviceLocator = serviceLocator;
    }
    private EntityManager createEntityManager(){
        return serviceLocator.getEntityManagerFactory().createEntityManager();
    }

    private UserRepository getUserRepository(){
        return new UserRepository(createEntityManager());
    }
    private ProjectRepository getProjectRepository(){
        return new ProjectRepository(createEntityManager());
    }
    private TaskRepository getTaskRepository(){
        return new TaskRepository(createEntityManager());
    }

    public Task createTask(
            final String userId,
            final String projectId,
            final String name,
            final String description
    ) throws IOException {
        if(userId == null || userId.isEmpty()) return null;
        if(projectId== null || projectId.isEmpty()) return null;
        if(name == null || name.isEmpty()) return null;
        if(description== null || description.isEmpty()) return null;

        UserRepository userRepository = getUserRepository();
        User user = userRepository.getUserById(userId);
        if(user == null) return null;

        ProjectRepository projectRepository = getProjectRepository();
        Project project = projectRepository.getProjectById(projectId);
        if(project == null) return null;

        TaskRepository taskRepository = getTaskRepository();
        taskRepository.begin();
        Task task = taskRepository.createTask(user, project, name, description);
        taskRepository.commit();
        taskRepository.close();
        return task;
    }

    public Task getTaskById(final String taskId) {
        if(taskId == null || taskId.isEmpty()) return null;
        TaskRepository taskRepository = getTaskRepository();
        return taskRepository.getTaskById(taskId);
    }

    public Collection<Task> getTaskList() {
        TaskRepository taskRepository = getTaskRepository();
        return taskRepository.getTaskList();
    }

    public Task updateTask(
            final String taskId,
            final String name,
            final String description) {
        TaskRepository taskRepository = getTaskRepository();
        taskRepository.begin();
        Task task = taskRepository.updateTask(
                taskId,
                name,
                description);
        taskRepository.commit();
        taskRepository.close();
        return task;
    }

    public void setTaskList(final Collection<Task> taskList) {
        TaskRepository taskRepository = getTaskRepository();
        taskRepository.begin();
        taskRepository.setTaskList(taskList);
        taskRepository.commit();
        taskRepository.close();
    }

    public void removeTask(final String taskId) throws IOException {
        if(taskId == null || taskId.isEmpty()) return;
        TaskRepository taskRepository = getTaskRepository();
        taskRepository.begin();
        taskRepository.deleteTask(taskId);
        taskRepository.commit();
        taskRepository.close();
    }

}
