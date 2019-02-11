package ru.atkachev.tm.bootstrap;

import ru.atkachev.tm.endpoint.ProjectEndpoint;
import ru.atkachev.tm.endpoint.SessionEndpoint;
import ru.atkachev.tm.endpoint.TaskEndpoint;
import ru.atkachev.tm.endpoint.UserEndpoint;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.SessionRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.repository.UserRepository;
import ru.atkachev.tm.service.ProjectService;
import ru.atkachev.tm.service.SessionService;
import ru.atkachev.tm.service.TaskService;
import ru.atkachev.tm.service.UserService;

import javax.xml.ws.Endpoint;
import java.util.*;

public class Bootstrap {

    private User currentUser;

    final private TaskRepository taskRepository = new TaskRepository();
    final private ProjectRepository projectRepository = new ProjectRepository();
    final private UserRepository userRepository = new UserRepository();
    final private SessionRepository sessionRepository = new SessionRepository();

    final private TaskService taskService = new TaskService(taskRepository);
    final private ProjectService projectService = new ProjectService(projectRepository, taskRepository);
    final private UserService userService = new UserService(userRepository);
    final private SessionService sessionService = new SessionService(sessionRepository);

    final private ProjectEndpoint projectEndpoint = new ProjectEndpoint(projectService);
    final private TaskEndpoint taskEndpoint = new TaskEndpoint(taskService);
    final private UserEndpoint userEndpoint = new UserEndpoint(userService);
    final private SessionEndpoint sessionEndpoint = new SessionEndpoint(sessionService);

    final private Scanner scanner = new Scanner(System.in);

    public void init(){
        Endpoint.publish("http://localhost:8080/ProjectService?wsdl", projectEndpoint);
        Endpoint.publish("http://localhost:8080/TaskService?wsdl", taskEndpoint);
        Endpoint.publish("http://localhost:8080/UserService?wsdl", userEndpoint);
        Endpoint.publish("http://localhost:8080/SessionService?wsdl", sessionEndpoint);
    }
}
