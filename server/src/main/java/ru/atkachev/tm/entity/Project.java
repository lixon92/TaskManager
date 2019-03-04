package ru.atkachev.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "PROJECT_TBL")
@Setter
@Getter
@NoArgsConstructor
public class Project implements Serializable {

    @Id
    private String id = UUID.randomUUID().toString();
    private Date dateCreated = new Date();
    private String description;
    private String name;
    private User user;

    private String userId;

}
