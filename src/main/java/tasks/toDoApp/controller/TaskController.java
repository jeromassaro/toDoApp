package tasks.toDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Task> getTaskById(Long id){
        Task task = taskService.getTaskById(id);
        if (task == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody TaskCreationDTO task){
        return new ResponseEntity<>(taskService.createTask(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody TaskCreationDTO task){
        return new ResponseEntity(taskService.updateTask(id,task),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> markTaskAsCompleted(@PathVariable Long id){
        Task task = taskService.markAsCompleted(id);
        if (task == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestBody StatusDTO dto){
        TaskStatus status = TaskStatus.valueOf(dto.getStatus().toUpperCase());
        taskService.updateStatus(id,status);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("?status=COMPLETED")
    public List<Task> getTaskByStatus(@PathVariable TaskStatus status){
        return taskService.getTasksByStatus(status);
    }
}
