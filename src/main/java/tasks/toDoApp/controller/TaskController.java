package tasks.toDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tasks.toDoApp.dto.StatusDTO;
import tasks.toDoApp.model.Task;
import tasks.toDoApp.dto.TaskCreationDTO;
import tasks.toDoApp.model.TaskStatus;
import tasks.toDoApp.service.TaskService;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks (){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(Long id){
        return taskService.getTaskById(id);
    }

    @PutMapping
    public Task createTask(@RequestBody TaskCreationDTO task){
        return taskService.createTask(task);
    }

    @PostMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody TaskCreationDTO task){
        return taskService.updateTask(id,task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
    }

    @PatchMapping("/{id}")
    public void markTaskAsCompleted(@PathVariable Long id){
        taskService.markAsCompleted(id);
    }

    @PatchMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestBody StatusDTO dto){
        TaskStatus status = TaskStatus.valueOf(dto.getStatus().toUpperCase());
        taskService.updateStatus(id,status);
    }

    @GetMapping("?status=COMPLETED")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }
}
