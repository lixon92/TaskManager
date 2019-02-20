package ru.atkachev.tm.service;

import ru.atkachev.tm.entity.Task;
import ru.atkachev.tm.repository.ProjectRepository;
import ru.atkachev.tm.repository.TaskRepository;
import ru.atkachev.tm.util.Util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class TaskService {

    final private TaskRepository taskRepository;
    final private ProjectRepository projectRepository;

    public TaskService(final TaskRepository taskRepository, final ProjectRepository projectRepository){
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    public void createTask(final String userID, final String projectId, final String name, final String description) throws IOException {
        Connection connection = Util.getConnection();
        try {
            taskRepository.createTask(connection, userID, projectId, name, description);
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

    public void deleteTask(final String taskId) throws IOException {
        Connection connection = Util.getConnection();
        try {
            taskRepository.deleteTask(connection, taskId);
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

    public void updateTask(final String taskId, final String name, final String description) {
        Connection connection = Util.getConnection();
        try {
            taskRepository.updateTask(connection, taskId, name, description);
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

    public Collection<Task> getTaskList() {
        Connection connection = Util.getConnection();
        try {
            return taskRepository.getTaskList(connection);
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

    public void setTaskList(final Collection<Task> taskList) {
        taskRepository.setTaskList(taskList);
    }

    public Task getTaskById(final String taskId) {
        Connection connection = Util.getConnection();
        try {
            return taskRepository.getTaskById(connection, taskId);
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

}
