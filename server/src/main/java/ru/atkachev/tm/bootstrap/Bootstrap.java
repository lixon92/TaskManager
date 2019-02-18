package ru.atkachev.tm.bootstrap;

import ru.atkachev.tm.endpoint.*;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.SessionRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.repository.UserRepository;
import ru.atkachev.tm.service.*;
import javax.xml.ws.Endpoint;

public class Bootstrap {

    final private ProjectRepository projectRepository = new ProjectRepository();
    final private TaskRepository taskRepository = new TaskRepository();
    final private UserRepository userRepository = new UserRepository();
    final private SessionRepository sessionRepository = new SessionRepository();

    final private TaskService taskService = new TaskService(taskRepository, projectRepository);
    final private UserService userService = new UserService(userRepository);
    final private SessionService sessionService = new SessionService(sessionRepository, userRepository);
    final private ProjectService projectService = new ProjectService(projectRepository, taskRepository);
    final private DomainService domainService = new DomainService(projectRepository, taskRepository, userRepository);

    final private ProjectEndpoint projectEndpoint = new ProjectEndpoint(projectService);
    final private TaskEndpoint taskEndpoint = new TaskEndpoint(taskService);
    final private UserEndpoint userEndpoint = new UserEndpoint(userService);
    final private SessionEndpoint sessionEndpoint = new SessionEndpoint(sessionService);
    final private DomainEndpoint domainEndpoint = new DomainEndpoint(domainService);

    public void init(){
        Endpoint.publish("http://localhost:8080/ProjectService?wsdl", projectEndpoint);
        Endpoint.publish("http://localhost:8080/TaskService?wsdl", taskEndpoint);
        Endpoint.publish("http://localhost:8080/UserService?wsdl", userEndpoint);
        Endpoint.publish("http://localhost:8080/SessionService?wsdl", sessionEndpoint);
        Endpoint.publish("http://localhost:8080/DomainService?wsdl", domainEndpoint);
    }
}
