package ru.atkachev.tm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
public class Domain implements Serializable {

    private Collection<Project> projects;
    private Collection<Task> tasks;
    private Collection<User> users;

}
