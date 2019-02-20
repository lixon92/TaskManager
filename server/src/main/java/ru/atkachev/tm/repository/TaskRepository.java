package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Task;
import java.sql.*;
import java.util.*;

public class TaskRepository {

    final private Map<String, Task> taskMap = new HashMap<>();

    public void createTask(final Connection connection, final String userId, final String projectId,
                           final String name, final String description) throws SQLException {

        String sql = "INSERT INTO task_manager.task (id, userId, projectId, name, description) VALUES (?, ?, ?, ?, ?);";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, UUID.randomUUID().toString());
        preparedStatement.setString(2, userId);
        preparedStatement.setString(3, projectId);
        preparedStatement.setString(4, name);
        preparedStatement.setString(5, description);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void deleteTask(final Connection connection, final String taskId) throws SQLException {
        String sql = "DELETE FROM task_manager.task WHERE id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, taskId);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void updateTask(final  Connection connection, final String taskId, final String name, final String description) throws SQLException {
        String sql = "UPDATE task_manager.task SET name = ?, description = ?  WHERE  id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, name);
        preparedStatement.setString(2, description);
        preparedStatement.setString(3, taskId);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void setTaskList(final Collection<Task> taskList) {
        for (Task task : taskList) {
            taskMap.put(task.getId(), task);
        }
    }

    public Task getTaskById(final Connection connection, final String taskId) throws SQLException {
        final Task task = new Task();
        final String sql = "SELECT id, projectId, userId, name, dateCreated, description FROM task_manager.task WHERE id = ?";
        final PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, taskId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            task.setId(resultSet.getString("id"));
            task.setUserId(resultSet.getString("userId"));
            task.setUserId(resultSet.getString("projectId"));
            task.setDateCreated(resultSet.getDate("dateCreated"));
            task.setName(resultSet.getString("name"));
            task.setDescribe(resultSet.getString("description"));
        }
        preparedStatement.close();

        return task;
    }

    public Collection<Task> getTaskList(final Connection connection) throws SQLException {
        final List<Task> taskList = new ArrayList<>();
        final String sql = "SELECT id, projectId, userId, name, dateCreated, description " +
                "FROM task_manager.task";

        final Statement statement = connection.createStatement();
        final ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Task task = new Task();
            task.setId(resultSet.getString("id"));
            task.setProjectId(resultSet.getString("projectId"));
            task.setUserId(resultSet.getString("userId"));
            task.setDateCreated(resultSet.getDate("dateCreated"));
            task.setName(resultSet.getString("name"));
            task.setDescribe(resultSet.getString("description"));
            taskList.add(task);
        }
        statement.close();

        return taskList;
    }
}
