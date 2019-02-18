package ru.atkachev.tm.entity;

import java.io.Serializable;
import java.util.Collection;

public class Domain implements Serializable {

    private Collection<Project> projects;
    private Collection<Task> tasks;
    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }
    public void setUsers(final Collection<User> users) {
        this.users = users;
    }

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(final Collection<Project> projects) {
        this.projects = projects;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    public void setTasks(final Collection<Task> tasks) {
        this.tasks = tasks;
    }

}
