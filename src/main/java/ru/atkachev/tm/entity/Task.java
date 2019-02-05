package ru.atkachev.tm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Task implements Serializable {

    final private Date dateCreated = new Date();
    final private String id = UUID.randomUUID().toString();
    private String UserID;
    private String projectId;
    private String describe;
    private String name;

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
    public String getProjectId() {
        return projectId;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setDescribe(String describe){
        this.describe = describe;
    }
    public String getDescribe(){
        return describe;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }
    public String getUserID() {
        return UserID;
    }

    public String  getId(){
        return id;
    }

    public Date getDateCreated (){
        return dateCreated;
    }

}
