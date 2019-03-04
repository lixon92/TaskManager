package ru.atkachev.tm;

import org.junit.Test;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.bootstrap.Bootstrap;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.service.ProjectService;

public class TestProjectService {

    final private IServiceLocator serviceLocator = new Bootstrap();
    final private ProjectService projectService = new ProjectService(serviceLocator);

    @Test
    public void testCreateProject() throws Exception{

        Project project = projectService.createProject(
                "11bc1b16-afce-4197-99c4-29035b661fd6",
                "Project1",
                "test"
        );

        System.out.println(project);
    }

    @Test
    public void testGetProjectById() throws Exception{

        Project project = projectService.getProjectById("a6642c1b-6fba-413b-859a-22be888fe575");
        for (Task task : project.getTaskList()){
            System.out.println(task.getName());
        }
        System.out.println(project);
    }

}
