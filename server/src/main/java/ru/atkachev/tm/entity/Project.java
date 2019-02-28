package ru.atkachev.tm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
public class Project implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();
    private Date dateCreated = new Date();
    private String description;
    private String name;

//    @OneToOne()
    private User user;
    private String userId;
    public Project(){

    }

//    public Project(User user){
//        this.user = user;
//    }

//    public User getUser() {
//        return user;
//    }
//    public void setUser(User user) {
//        this.user = user;
//    }

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

    public String getDescribe() {
        return description;
    }
    public void setDescribe(final String describe) {
        this.description = describe;
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
