package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.util.Util;

import java.sql.*;
import java.util.*;

public class ProjectRepository {

    final private Map<String, Project> projectMap = new HashMap<>();

    public void createProject(Connection connection, final String userId, final String name, final String description) throws SQLException {
        String sql = "INSERT INTO task_manager.project (id, Userid, name, description) VALUES (?, ?, ?, ?)";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, UUID.randomUUID().toString());
        preparedStatement.setString(2, userId);
        preparedStatement.setString(3, name);
        preparedStatement.setString(4, description);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void deleteProject(Connection connection, final String projectId) throws SQLException {
        String sql = "DELETE FROM task_manager.project WHERE id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, projectId);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updateProject(final Connection connection, final String projectId, final String name, final String description) throws SQLException {
        String sql = "UPDATE task_manager.project SET name = ?, description = ?  WHERE  id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, description);
        preparedStatement.setString(3, projectId);
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public Collection<Project> getProjectList(Connection connection) throws SQLException {
        final List<Project> projectList = new ArrayList<>();
        final String sql = "SELECT id, userId, name, dateCreated, description " +
                "FROM task_manager.project";

        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Project project = new Project();
            project.setId(resultSet.getString("id"));
            project.setUserId(resultSet.getString("userId"));
            project.setDateCreated(resultSet.getDate("dateCreated"));
            project.setName(resultSet.getString("name"));
            project.setDescribe(resultSet.getString("description"));
            projectList.add(project);
        }
        statement.close();

        return projectList;
    }

    public Project getProjectById(Connection connection, final String projectId) throws SQLException {
        final Project project = new Project();
        final String sql = "SELECT id, userId, name, dateCreated, description FROM task_manager.project WHERE id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, projectId.trim());
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            project.setId(resultSet.getString("id"));
            project.setUserId(resultSet.getString("userId"));
            project.setDateCreated(resultSet.getDate("dateCreated"));
            project.setName(resultSet.getString("name"));
            project.setDescribe(resultSet.getString("description"));
        }
        preparedStatement.close();

        return project;
    }

    public void setProjectList(final Collection<Project> projectList) {
        for (final Project project : projectList) {
            projectMap.put(project.getId(), project);
        }
    }
}
