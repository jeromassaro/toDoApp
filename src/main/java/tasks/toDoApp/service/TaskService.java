package tasks.toDoApp.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks.toDoApp.model.Task;
import tasks.toDoApp.model.TaskCreationDTO;
import tasks.toDoApp.model.TaskStatus;
import tasks.toDoApp.respository.TaskRepository;

import java.util.List;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private TaskRepository taskRepository;
    @Override
    public List<Task> listarTareas() {
        return taskRepository.findAll();
    }

    @Override
    public Task crearTarea(TaskCreationDTO taskDTO) {
        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setCompleted(taskDTO.isCompleted());
        return taskRepository.save(task);
    }

    @Override
    public Task actualizarTarea(Long id, TaskCreationDTO taskDTO) {
        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setCompleted(taskDTO.isCompleted());
        return taskRepository.save(task);
    }

    @Override
    public void eliminarTarea(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task obtenerTareaPorId(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> obtenerTareasPorStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }

    @Transactional
    @Override
    public void updateStatus(Long id, TaskStatus status) {
        taskRepository.updateStatus(id,status);
    }

    @Override
    public Task markAsCompleted(Long id){
        Task task = taskRepository.findById(id).orElse(null);
        task.setCompleted(true);
        return taskRepository.save(task);
    }
}
