package ru.atkachev.tm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Project implements Serializable {

    private Date dateCreated = new Date();
    private String id = UUID.randomUUID().toString();
    private String describe;
    private String name;
    private String userId;

    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}

