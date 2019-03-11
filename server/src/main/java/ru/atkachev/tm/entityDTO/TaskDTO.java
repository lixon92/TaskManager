package ru.atkachev.tm.entityDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.atkachev.tm.entity.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
public class TaskDTO {

    private String id;
    private Date dateCreated;
    private String description;
    private String name;
    private String userId;
    private String projectId;

    public TaskDTO(Task task){
        this.id = task.getId();
        this.dateCreated = task.getDateCreated();
        this.description = task.getDescription();
        this.name = task.getName();
        this.userId = task.getUser().getId();
        this.projectId = task.getProject().getId();
    }

    public static TaskDTO toDTO(Task task){
        return new TaskDTO(task);
    }

    public static Collection<TaskDTO> toListDTO(Collection<Task> tasks){
        Collection<TaskDTO> tasksDTO = new ArrayList<>();
        for(Task task : tasks){
            tasksDTO.add(new TaskDTO(task));
        }
        return tasksDTO;
    }
}
