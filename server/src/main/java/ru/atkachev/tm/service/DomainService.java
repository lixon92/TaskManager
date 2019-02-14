package ru.atkachev.tm.service;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ru.atkachev.tm.entity.Domain;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.repository.UserRepository;

import java.io.*;
import java.util.List;

public class DomainService {
    private ProjectRepository projectRepository;
    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public DomainService(ProjectRepository projectRepository, TaskRepository taskRepository, UserRepository userRepository){
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public void xmlSave(){
        Domain domain = new Domain();
        domain.setProjects(projectRepository.getProjectList());
        domain.setTasks(taskRepository.getTaskList());
        domain.setUsers(userRepository.getUserList());
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("File.xml");
        try {
            xmlMapper.writeValue(file, domain);
        } catch (IOException e){
            System.out.println("IOException!!!");
        }
    }

    public void xmlLoad(){
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("File.xml");
        try{
            projectRepository.setProjectList(xmlMapper.readValue(file, Domain.class).getProjects());
            taskRepository.setTaskList(xmlMapper.readValue(file, Domain.class).getTasks());
            userRepository.setUserList(xmlMapper.readValue(file, Domain.class).getUsers());
        } catch (IOException e){
            System.out.println("IOException");
        }
    }
}
