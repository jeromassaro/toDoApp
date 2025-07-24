package tasks.toDoApp.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks.toDoApp.model.Task;
import tasks.toDoApp.dto.TaskCreationDTO;
import tasks.toDoApp.model.TaskStatus;
import tasks.toDoApp.respository.TaskRepository;

import java.util.List;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private TaskRepository taskRepository;

    @Transactional
    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Transactional
    @Override
    public Task createTask(TaskCreationDTO taskDTO) {
        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setCompleted(taskDTO.isCompleted());
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public Task updateTask(Long id, TaskCreationDTO taskDTO) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) return null;
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        task.setCompleted(taskDTO.isCompleted());
        return taskRepository.save(task);
    }

    @Transactional
    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    @Transactional
    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findAllByStatus(status);
    }

    @Transactional
    @Override
    public void updateStatus(Long id, TaskStatus status) {
        taskRepository.updateStatus(id,status);
    }

    @Transactional
    @Override
    public Task markAsCompleted(Long id){
        Task task = taskRepository.findById(id).orElse(null);
        if (task == null) return null;
        task.setCompleted(true);
        return taskRepository.save(task);
    }
}
