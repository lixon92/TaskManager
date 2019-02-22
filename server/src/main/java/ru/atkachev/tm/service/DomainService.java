package ru.atkachev.tm.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.atkachev.tm.entity.Domain;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.entity.User;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.repository.UserRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DomainService {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public DomainService(final ProjectRepository projectRepository, final TaskRepository taskRepository, final UserRepository userRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public void jsonSave() throws IOException {
//        final File file = new File("File.json");
//        final ObjectMapper objectMapper = new ObjectMapper();
//        final Domain domain = new Domain();
//        domain.setProjects(projectRepository.getProjectList());
//        domain.setTasks(taskRepository.getTaskList());
//        domain.setUsers(userRepository.getUserList());
//        objectMapper.writeValue(file, domain);
    }

    public void jsonLoad() throws IOException {
//        final File file = new File("File.json");
//        final ObjectMapper objectMapper = new ObjectMapper();
//        final Domain domain = objectMapper.readValue(file, Domain.class);
//        projectRepository.setProjectList(domain.getProjects());
//        taskRepository.setTaskList(domain.getTasks());
//        userRepository.setUserList(domain.getUsers());
    }

    public void jsonClean() {
        final File file = new File("File.json");
        file.delete();
//        final ObjectMapper objectMapper = new XmlMapper();
//        final Domain domain = new Domain();
//        domain.setProjects(projectRepository.getProjectList());
//        domain.setTasks(taskRepository.getTaskList());
//        domain.setUsers(userRepository.getUserList());
//        objectMapper. remove(file);
//                writeValue(file, domain);
    }

    public void xmlSave() throws IOException {
//        final Domain domain = new Domain();
//        final File file = new File("File.xml");
//        final ObjectMapper objectMapper = new XmlMapper();
//        domain.setProjects(projectRepository.getProjectList());
//        domain.setTasks(taskRepository.getTaskList());
//        domain.setUsers(userRepository.getUserList());
//        objectMapper.writeValue(file, domain);
    }

    public void xmlLoad() throws IOException, NullPointerException {
//        final File file = new File("File.xml");
//        final ObjectMapper objectMapper = new XmlMapper();
//        final Domain domain = objectMapper.readValue(file, Domain.class);
//        projectRepository.setProjectList(domain.getProjects());
//        taskRepository.setTaskList(domain.getTasks());
//        userRepository.setUserList(domain.getUsers());
    }

    public void xmlClean() throws IOException {
        final File file = new File("File.xml");
        final ObjectMapper objectMapper = new XmlMapper();
        final Domain domain = new Domain();
        domain.setProjects(new ArrayList<Project>());
        domain.setTasks(new ArrayList<Task>());
        domain.setUsers(new ArrayList<User>());
        objectMapper.writeValue(file, domain);
    }

    public void binSave() throws IOException {
//        ObjectOutputStream objectOutputStream =
//                new ObjectOutputStream(new FileOutputStream("File.bin"));
//        final Domain domain = new Domain();
//        domain.setProjects(projectRepository.getProjectList());
//        domain.setTasks(taskRepository.getTaskList());
//        domain.setUsers(userRepository.getUserList());
//        objectOutputStream.writeObject(domain);
//        objectOutputStream.close();
    }

    public void binLoad() throws IOException, ClassNotFoundException {
//        ObjectInputStream objectInputStream =
//                new ObjectInputStream(new FileInputStream("File.bin"));
//        final Domain domain = (Domain) objectInputStream.readObject();
//        projectRepository.setProjectList(domain.getProjects());
//        taskRepository.setTaskList(domain.getTasks());
//        userRepository.setUserList(domain.getUsers());
//        objectInputStream.close();
    }
}
