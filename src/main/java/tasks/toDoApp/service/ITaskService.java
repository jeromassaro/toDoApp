package tasks.toDoApp.service;

import org.springframework.stereotype.Service;
import tasks.toDoApp.model.Task;
import tasks.toDoApp.dto.TaskCreationDTO;
import tasks.toDoApp.model.TaskStatus;

import java.util.List;

@Service
public interface ITaskService {

    public List<Task> getAllTasks();
    public Task createTask(TaskCreationDTO taskDTO);
    public Task updateTask(Long id, TaskCreationDTO taskDTO);
    public void deleteTask(Long id);
    public Task getTaskById(Long id);
    public List<Task> getTasksByStatus(TaskStatus status);
    public void updateStatus(Long id, TaskStatus status);
    public Task markAsCompleted(Long id);
}
