package ru.atkachev.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "PROJECT_TBL")
@NamedQuery(name = "getAllProjects", query = "SELECT p from Project p")
public class Project implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();
    private Date dateCreated = new Date();
    private String description;
    private String name;

    @ManyToOne
    private User user;

    @OneToMany(
            mappedBy = "project",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    List<Task> taskList;

    @Override
    public String toString() {
        return "Project{" +
                "id='" + id + '\'' +
                ", dateCreated=" + dateCreated +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", user=" + user +
                '}';
    }

}


