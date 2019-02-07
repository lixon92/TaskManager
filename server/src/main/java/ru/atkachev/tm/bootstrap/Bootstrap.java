package ru.atkachev.tm.bootstrap;

import ru.atkachev.tm.endpoint.ProjectEndpoint;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.repository.UserRepository;
import ru.atkachev.tm.service.ProjectService;
import ru.atkachev.tm.service.TaskService;
import ru.atkachev.tm.service.UserService;

import javax.xml.ws.Endpoint;
import java.util.*;

public class Bootstrap {

    private User currentUser;

    final private TaskRepository taskRepository = new TaskRepository();
    final private ProjectRepository projectRepository = new ProjectRepository();
    final private UserRepository userRepository = new UserRepository();

    final private TaskService taskService = new TaskService(taskRepository);
    final private ProjectService projectService = new ProjectService(projectRepository, taskRepository);
    final private UserService userService = new UserService(userRepository);

    final private ProjectEndpoint projectEndpoint = new ProjectEndpoint(projectService);

    final private Scanner scanner = new Scanner(System.in);

    public void init(){

        Endpoint.publish("http://localhost:8080/TestWebService?wsdl", projectEndpoint);

    }

}
