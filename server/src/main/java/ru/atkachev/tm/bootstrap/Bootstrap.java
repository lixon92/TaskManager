package ru.atkachev.tm.bootstrap;

import ru.atkachev.tm.api.IServiceLocator;
import ru.atkachev.tm.endpoint.*;
import ru.atkachev.tm.repository.*;
import ru.atkachev.tm.service.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.xml.ws.Endpoint;

public class Bootstrap implements IServiceLocator {

    final private IServiceLocator serviceLocator = this;
    final private UserService userService = new UserService(serviceLocator);
    final private SessionService sessionService = new SessionService(serviceLocator);
    final private ProjectService projectService = new ProjectService(serviceLocator);
    final private TaskService taskService = new TaskService(serviceLocator);

    final private EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("DEVELOPMENT");

    final private TaskRepository taskRepository = new TaskRepository();
    final private UserRepository userRepository = new UserRepository();
    final private ProjectRepository projectRepository = new ProjectRepository();


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

    public EntityManagerFactory getEntityManagerFactory(){
        return entityManagerFactory;
    }

}
