package tasks.toDoApp.service;

import org.springframework.stereotype.Service;
import tasks.toDoApp.model.Task;
import tasks.toDoApp.model.TaskCreationDTO;
import tasks.toDoApp.model.TaskStatus;

import java.util.List;

@Service
public interface ITaskService {

    public List<Task> listarTareas();
    public Task crearTarea(TaskCreationDTO taskDTO);
    public Task actualizarTarea(Long id, TaskCreationDTO taskDTO);
    public void eliminarTarea(Long id);
    public Task obtenerTareaPorId(Long id);
    public List<Task> obtenerTareasPorStatus(TaskStatus status);
    public void updateStatus(Long id, TaskStatus status);

    Task markAsCompleted(Long id);
}
