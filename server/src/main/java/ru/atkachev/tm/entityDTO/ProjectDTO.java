package ru.atkachev.tm.entityDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.atkachev.tm.entity.Project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDTO {

    private String id;
    private Date dateCreated;
    private String description;
    private String name;
    private String userId;

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

    public static Collection<ProjectDTO> toListDTO(Collection<Project> projects){
        Collection<ProjectDTO> projectsDTO = new ArrayList<>();
        for(Project project : projects){
            projectsDTO.add(new ProjectDTO(project));
        }
        return projectsDTO;
    }
}
