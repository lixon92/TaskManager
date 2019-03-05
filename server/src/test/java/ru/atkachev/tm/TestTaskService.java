package ru.atkachev.tm;

import org.junit.Test;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.bootstrap.Bootstrap;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.service.TaskService;

import java.util.Collection;

public class TestTaskService {

    final private IServiceLocator serviceLocator = new Bootstrap();
    final private TaskService taskService = new TaskService(serviceLocator);

    @Test
    public void testCreateTask() throws Exception{

        for(int i = 0; i < 4; i++){
            taskService.createTask(
                    "8bc6a26f-8945-485c-9f64-44595e8776b1",
                    "e41b032e-e99a-4817-9655-3c69138f6645",
                    "task"+i,
                    "test"
            );
        }

    }

    @Test
    public void testUpdateTask() throws Exception{

        Task task = taskService.updateTask(
                "a586d3ca-7f8e-4a3a-aa1b-cbe2d877a709",
                "updateTask",
                "updateTask"
        );
        System.out.println(task);
    }

    @Test
    public void testGetTaskById() throws Exception{

        Task task = taskService.getTaskById(
                "a586d3ca-7f8e-4a3a-aa1b-cbe2d877a709");
        System.out.println(task);
    }

    @Test
    public void testGetAllTasks() throws Exception{
        Collection<Task> tasks = taskService.getTaskList();
        for(Task task : tasks){
            System.out.println(task);
        }
    }

    @Test
    public void testRemoveTask() throws Exception{
        taskService.removeTask("a586d3ca-7f8e-4a3a-aa1b-cbe2d877a709");
    }

}
