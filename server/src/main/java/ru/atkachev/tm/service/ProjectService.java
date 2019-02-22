package ru.atkachev.tm.service;

import org.apache.ibatis.session.SqlSession;
import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.util.MyBatisUtil;
import ru.atkachev.tm.util.ValidateSession;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static ru.atkachev.tm.util.ValidateSession.validate;

public class ProjectService {

//    final private ProjectRepository projectRepository;
    final private TaskRepository taskRepository;

    public ProjectService( final TaskRepository taskRepository) {
//        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

//    public Project getProjectById(final String projectId) {
//        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//        ProjectRepository mapper = session.getMapper(ProjectRepository.class);
//        mapper.selectProject(projectId);
//        session.commit();
//        session.close();
//        return projectRepository.getProjectById(projectId);
//    }

    public void createProject(final String userId, final String name, final String description) {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        ProjectRepository mapper = session.getMapper(ProjectRepository.class);
        Project project = new Project();
        project.setUserId(userId);
        project.setName(name);
        project.setDescribe(description);
        mapper.insertProject(project);
        session.commit();
        session.close();
    }
//
//    public void updateProject(final String projectId, final String name, final String description) {
//        projectRepository.updateProject(projectId, name, description);
//    }
//
//    public void deleteProject(final String projectId) throws IOException {
//        if(projectRepository.getProjectById(projectId) == null) throw new IOException();
//        projectRepository.deleteProject(projectId);
//    }

    public Collection<Project> getProjectList() {
        SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
        ProjectRepository mapper = session.getMapper(ProjectRepository.class);
        Collection<Project> projects = mapper.selectProject();
        session.close();
        return projects;
    }
//
//    public void setProjectList(final List<Project> projectList) {
//        projectRepository.setProjectList(projectList);
//    }
}
