package ru.atkachev.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "TASK_TBL")
@NoArgsConstructor
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
