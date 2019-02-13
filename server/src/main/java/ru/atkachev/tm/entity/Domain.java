package ru.atkachev.tm.entity;

import java.util.Collection;

public class Domain {

    private Collection<Project> projects;
    private Collection<Task> tasks;

    public Collection<Project> getProjectList() {
        return projects;
    }

    public void setProjectList(Collection<Project> projects) {
        this.projects = projects;
    }

    public Collection<Task> getTaskList() {
        return tasks;
    }

    public void setTaskList(Collection<Task> tasks) {
        this.tasks = tasks;
    }
}
