package ru.atkachev.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "TASK_TBL")
@NamedQuery(name = "getAllTasks", query = "SELECT t from Task t")
public class Task implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();
    private Date dateCreated = new Date();
    private String description;
    private String name;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;

    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", user=" + user +
                ", project=" + project +
                ", describe='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}

