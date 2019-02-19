package ru.atkachev.tm.repository;

import ru.atkachev.tm.entity.Project;
import ru.atkachev.tm.util.Util;

import java.sql.*;
import java.util.*;

public class ProjectRepository {

    private Connection connection = Util.getConnection();

    final private Map<String, Project> projectMap = new HashMap<>();

    public void createProject(final String userId, final String name, final String description) {
        PreparedStatement preparedStatement = null;

//        final Project project = new Project();
//        project.setUserId(userId);
//        project.setName(name);
//        project.setDescribe(description);
//        projectMap.put(project.getId(), project);

        String sql = "INSERT INTO task_manager.project (id, Userid, name, description) VALUES (?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, UUID.randomUUID().toString());
            preparedStatement.setString(2, userId);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, description);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void deleteProject(final String projectId){
        projectMap.remove(projectId);
    }

    public void updateProject(final String projectId, final String name, final String description ){
        projectMap.get(projectId).setName(name);
        projectMap.get(projectId).setDescribe(description);
    }

    public Collection<Project> getProjectList(){
        List<Project> projectList = new ArrayList<>();
        String sql = "SELECT id, userId, name, description FROM task_manager.project";
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                Project project = new Project();
                project.setId(resultSet.getString("id"));
                project.setUserId(resultSet.getString("userId"));
//                project.setDateCreated(resultSet.getDate("dateCreated"));
                project.setName(resultSet.getString("name"));
                project.setDescribe(resultSet.getString("description"));

                projectList.add(project);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        finally {
//            try {
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

//        return projectMap.values();
        return projectList;
    }

    public Project getProjectById(final String projectId){
        return projectMap.get(projectId);
    }

    public void setProjectList(final Collection<Project> projectList) {
        for (final Project project : projectList) {
            projectMap.put(project.getId(), project);
        }

    }
}
