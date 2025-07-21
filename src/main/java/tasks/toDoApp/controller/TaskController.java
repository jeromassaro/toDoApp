package tasks.toDoApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tasks.toDoApp.model.StatusDTO;
import tasks.toDoApp.model.Task;
import tasks.toDoApp.model.TaskCreationDTO;
import tasks.toDoApp.model.TaskStatus;
import tasks.toDoApp.service.TaskService;

import java.util.List;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> obtenerTareas (){
        return taskService.listarTareas();
    }

    @GetMapping("/{id}")
    public Task obtenerTareaPorId(Long id){
        return taskService.obtenerTareaPorId(id);
    }

    @PutMapping
    public Task crearTarea(@RequestBody TaskCreationDTO task){
        return taskService.crearTarea(task);
    }

    @PostMapping("/{id}")
    public Task actualizarTarea(@PathVariable Long id, @RequestBody TaskCreationDTO task){
        return taskService.actualizarTarea(id,task);
    }

    @DeleteMapping("/{id}")
    public void eliminarTarea(@PathVariable Long id){
        taskService.eliminarTarea(id);
    }

    @PatchMapping("/{id}")
    public void completarTarea(@PathVariable Long id){
        taskService.markAsCompleted(id);
    }

    @PatchMapping("/{id}/status")
    public void updateStatus(@PathVariable Long id, @RequestBody StatusDTO dto){
        TaskStatus status = TaskStatus.valueOf(dto.getStatus().toUpperCase());
        taskService.updateStatus(id,status);
    }

    @GetMapping("/status/{status}")
    public List<Task> obtenerTareasPorStatus(@PathVariable TaskStatus status){
        return taskService.obtenerTareasPorStatus(status);
    }
}
