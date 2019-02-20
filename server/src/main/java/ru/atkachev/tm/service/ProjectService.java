package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.entity.Session;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.util.Util;
import ru.atkachev.tm.util.ValidateSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import static ru.atkachev.tm.util.ValidateSession.validate;

public class ProjectService {

    final private ProjectRepository projectRepository;
    final private TaskRepository taskRepository;

    public ProjectService(final ProjectRepository projectRepository, final TaskRepository taskRepository) {
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public Project getProjectById(final String projectId) {
        Connection connection = Util.getConnection();
        try {
            return projectRepository.getProjectById(connection, projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void createProject(final String userId, final String name, final String description) {
        Connection connection = Util.getConnection();
        try{
            projectRepository.createProject(connection, userId, name, description);
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateProject(final String projectId, final String name, final String description) {
        Connection connection = Util.getConnection();
        try {
            projectRepository.updateProject(connection, projectId, name, description);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteProject(final String projectId) throws IOException {
        Connection connection = Util.getConnection();
        try {
            projectRepository.deleteProject(connection, projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Collection<Project> getProjectList() {
        Connection connection = Util.getConnection();
        try {
            return projectRepository.getProjectList(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setProjectList(final List<Project> projectList) {
        projectRepository.setProjectList(projectList);
    }
}
