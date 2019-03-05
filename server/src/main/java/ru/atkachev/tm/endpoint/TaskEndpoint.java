package ru.atkachev.tm.endpoint;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.service.TaskService;
import ru.atkachev.tm.util.ValidateSession;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

@WebService
public class TaskEndpoint {
    final private TaskService taskService;
    public TaskEndpoint(final TaskService taskService){
        this.taskService = taskService;
    }

    @WebMethod
    public void createTask(
            @WebParam(name = "session") final Session session,
            @WebParam(name = "projectId")final String projectId,
            @WebParam(name = "name") final String name,
            @WebParam(name = "description") final String description
    ) throws IOException {
        ValidateSession.validate(session);
        taskService.createTask(session.getUserId(), projectId, name, description);
    }

    @WebMethod
    public void deleteTask(
            @WebParam(name = "session") final Session session,
            @WebParam(name = "taskId") final String taskId
    ) throws IOException {
        ValidateSession.validate(session);
        taskService.removeTask(taskId);
    }

    @WebMethod
    public void updateTask(
            @WebParam(name = "session") final Session session,
            @WebParam(name = "taskId") final String taskId,
            @WebParam(name = "name") final String name,
            @WebParam(name = "description") final String description
    ) {
        ValidateSession.validate(session);
        taskService.updateTask(taskId, name, description);
    }

    @WebMethod
    public Collection<Task> getTaskList(
            @WebParam(name = "session") Session session
    ) {
        ValidateSession.validate(session);
        return taskService.getTaskList();
    }

    @WebMethod
    public void setTaskList(
            @WebParam(name = "session") final Session session,
            @WebParam(name = "taskList") final List<Task> taskList
    ) {
        ValidateSession.validate(session);
        taskService.setTaskList(taskList);
    }

    @WebMethod
    public Task getTaskById(
            @WebParam(name = "session") final Session session,
            @WebParam(name = "taskId") final String taskId
    ) {
        ValidateSession.validate(session);
        return taskService.getTaskById(taskId);
    }
}
