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
        domain.setProjectList(projectRepository.getProjectList());
//        domain.setTaskList(taskRepository.getTaskList());

        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("File.xml");
//        File taskFile = new File("taskFile.xml");
//        File userFile = new File("userFile.xml");
        try {
            xmlMapper.writeValue(file, domain);
//            xmlMapper.writeValue(taskFile, taskRepository.getTaskList());
//            xmlMapper.writeValue(userFile, userRepository.getUserList());
        } catch (IOException e){
            System.out.println("IOException!!!");
        }
    }

    public void xmlLoad(){
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("File.xml");
//        File projectFile = new File("projectFile.xml");
//        File taskFile = new File("taskFile.xml");
//        File userFile = new File("userFile.xml");
        try{
//            String xmlProject = inputStreamToString(new FileInputStream(projectFile));
//            String xmlTask = inputStreamToString(new FileInputStream(taskFile));
//            String xmlUser = inputStreamToString(new FileInputStream(userFile));
//            Project[] projects = (Project[]) xmlMapper.reader();
            projectRepository.setProjectList(xmlMapper.readValue(file, Domain.class).getProjectList());
//            taskRepository = xmlMapper.readValue(taskFile, TaskRepository.class);
//            userRepository = xmlMapper.readValue(userFile, UserRepository.class);
        } catch (IOException e){
            System.out.println("IOException");
        }
    }

    public static String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }
}
