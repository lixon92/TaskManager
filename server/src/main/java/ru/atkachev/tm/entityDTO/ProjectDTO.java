package ru.atkachev.tm.entityDTO;

import ru.atkachev.tm.entity.Project;
import java.util.Date;

public class ProjectDTO {

    final private String id;
    final private Date dateCreated;
    final private String description;
    final private String name;
    final private String userId;

    public ProjectDTO(Project project){
        this.id = project.getId();
        this.dateCreated = project.getDateCreated();
        this.description = project.getDescription();
        this.name = project.getName();
        this.userId = project.getUser().getId();
    }

    public static ProjectDTO toDTO(Project project){
        return new ProjectDTO(project);
    }
}
