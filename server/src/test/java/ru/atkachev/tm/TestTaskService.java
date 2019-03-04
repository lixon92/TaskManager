package ru.atkachev.tm;

import org.junit.Test;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.bootstrap.Bootstrap;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.service.TaskService;

public class TestTaskService {

    final private IServiceLocator serviceLocator = new Bootstrap();
    final private TaskService taskService = new TaskService(serviceLocator);

    @Test
    public void testCreateTask() throws Exception{

        Task task = taskService.createTask(
                "11bc1b16-afce-4197-99c4-29035b661fd6",
                "a6642c1b-6fba-413b-859a-22be888fe575",
                "task4",
                "test"
        );

        System.out.println(task);
    }

}
