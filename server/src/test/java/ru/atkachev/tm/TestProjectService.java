package ru.atkachev.tm;

import org.junit.Test;
import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.bootstrap.Bootstrap;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.service.ProjectService;
import java.util.Collection;

public class TestProjectService {

    final private IServiceLocator serviceLocator = new Bootstrap();
    final private ProjectService projectService = new ProjectService(serviceLocator);

    @Test
    public void testCreateProject() throws Exception{

        Project project = projectService.createProject(
                "8bc6a26f-8945-485c-9f64-44595e8776b1",
                "Project3",
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

    @Test
    public void testUpdateProject() throws Exception{

        Project project = projectService.updateProject(
                "8bc6a26f-8945-485c-9f64-44595e8776b1",
                "update",
                "update"
        );
        System.out.println(project);
    }

    @Test
    public void testRemoveProject() throws Exception{
        projectService.removeProject("1541a0bf-895f-492c-aa99-b6ac98409aec");
    }

    @Test
    public void testAllProjects() throws Exception{

        Collection<Project> projects = projectService.getProjectList();
        for (Project project : projects){
            System.out.println(project);
            for (Task task : project.getTaskList()){
                System.out.println(task);
            }
        }
    }
}
