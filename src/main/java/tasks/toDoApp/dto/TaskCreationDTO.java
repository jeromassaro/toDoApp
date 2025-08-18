package tasks.toDoApp.dto;

import jakarta.validation.constraints.NotBlank;
import tasks.toDoApp.model.TaskStatus;

public class TaskCreationDTO {

    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;
    @NotBlank(message = "La descripcion no puede estar vacia")
    private String description;
    private TaskStatus status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }
}
