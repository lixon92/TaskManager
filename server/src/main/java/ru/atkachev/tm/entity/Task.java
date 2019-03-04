package ru.atkachev.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
public class Task implements Serializable {

    private Date dateCreated = new Date();
    private String id = UUID.randomUUID().toString();
    private String UserID;
    private String projectId;
    private String describe;
    private String name;

}
