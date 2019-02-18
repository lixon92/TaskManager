package ru.atkachev.tm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Task implements Serializable {

    private Date dateCreated = new Date();
    private String id = UUID.randomUUID().toString();
    private String UserID;
    private String projectId;
    private String describe;
    private String name;

    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(final Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }
    public void setId(final String id) {
        this.id = id;
    }

    public String getUserID() {
        return UserID;
    }
    public void setUserID(final String userID) {
        UserID = userID;
    }

    public String getProjectId() {
        return projectId;
    }
    public void setProjectId(final String projectId) {
        this.projectId = projectId;
    }

    public String getDescribe() {
        return describe;
    }
    public void setDescribe(final String describe) {
        this.describe = describe;
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }
}
