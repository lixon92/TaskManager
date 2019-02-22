package ru.atkachev.tm.repository;

import org.apache.ibatis.annotations.*;
import ru.atkachev.tm.entity.Project;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProjectRepository {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "dateCreated", column = "dateCreated"),
            @Result(property = "userId", column = "userId"),
            @Result(property = "name", column = "name"),
            @Result(property = "describe", column = "description")
    })
    @Select("SELECT id, dateCreated, userId, name, description from project")
    List<Project> selectProject();

    @Insert("INSERT into project(id, userId, name, description) VALUES(#{id}, #{userId}, #{name}, #{describe})")
    void insertProject(Project project);

//    @Update("UPDATE village SET name=#{villageName}, district =#{district} WHERE id =#{vid}")
//    void updateVillage(Village village);
//
//    @Delete("DELETE FROM village WHERE id =#{id}")
//    void deleteVillage(int id);
}
