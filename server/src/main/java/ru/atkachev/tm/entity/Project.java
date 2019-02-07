package ru.atkachev.tm.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Project implements Serializable {

    final private Date dateCreated = new Date();
    final private String id = UUID.randomUUID().toString();

    private String describe;
    private String name;
    private String userId;
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

    public String  getId(){
        return id;
    }

    public Date getDateCreated (){
        return dateCreated;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

