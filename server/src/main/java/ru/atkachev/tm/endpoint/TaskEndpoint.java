package ru.atkachev.tm.endpoint;

import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.service.TaskService;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public class TaskEndpoint {
    final private TaskService taskService;
    public TaskEndpoint(TaskService taskService){
        this.taskService = taskService;
    }

    @WebMethod
    public void createTask(
            @WebParam(name = "projectId")String projectId,
            @WebParam(name = "name")String name,
            @WebParam(name = "description")String description) {
        taskService.createTask(projectId, name, description);
    }
    @WebMethod
    public void deleteTask(
            @WebParam(name = "taskId")String taskId) {
        taskService.deleteTask(taskId);
    }
    @WebMethod
    public void updateTask(
            @WebParam(name = "taskId")String taskId,
            @WebParam(name = "name")String name,
            @WebParam(name = "description")String description) {
        taskService.updateTask(taskId, name, description);
    }
    @WebMethod
    public String getTaskList() {
        return taskService.getTaskList();
    }
    @WebMethod
    public void setTaskList(
            @WebParam(name = "taskList")List<Task> taskList) {
        taskService.setTaskList(taskList);
    }
    @WebMethod
    public Task getTaskById(
            @WebParam(name = "taskId")String taskId) {
        return taskService.getTaskById(taskId);
    }
}
