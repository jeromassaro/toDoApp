package tasks.toDoApp.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tasks.toDoApp.dto.TaskCreationDTO;
import tasks.toDoApp.model.Task;
import tasks.toDoApp.respository.TaskRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.Mockito.*;
import static tasks.toDoApp.model.TaskStatus.*;

@ExtendWith(MockitoExtension.class)
public class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task task1;
    private Task task2;
    private Task task3;
    private TaskCreationDTO taskDTO;

    @BeforeEach
    void setUp() {
        task1 = new Task();
        task1.setId(1L);
        task1.setName("Task 1");
        task1.setDescription("Description 1");
        task1.setStatus(EN_PROCESO);


        task2 = new Task();
        task2.setId(2L);
        task2.setName("Task 2");
        task2.setDescription("Description 2");
        task2.setStatus(En_ESPERA);

        task3 = new Task();
        task3.setId(3L);
        task3.setName("Task 3");
        task3.setDescription("Description 3");
        task3.setStatus(En_ESPERA);

        taskDTO = new TaskCreationDTO();
        taskDTO.setName("Task DTO");
        taskDTO.setDescription("Description DTO");
        taskDTO.setStatus(FINALIZADA);

    }

    @Test
    void getAllTasks() {

        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1,task2));

        List<Task> tasks = taskRepository.findAll();

        assertNotNull(tasks);
        assertEquals(2,tasks.size());
        assertEquals(2,tasks.get(1).getId());
    }

    @Test
    void createTask() {

        when(taskRepository.save(any(Task.class))).thenReturn(task1);
        Task created = taskService.createTask(taskDTO);

        assertNotNull(created);
        assertEquals(1,created.getId());
        assertEquals("Task 1",created.getName());
        assertEquals("Description 1",created.getDescription());
        assertEquals(EN_PROCESO,created.getStatus());
    }

    @Test
    void updateTask() {
        when(taskRepository.findById(1L)).thenReturn(java.util.Optional.of(task1));

        when(taskRepository.save(any(Task.class))).thenAnswer(returnsFirstArg());

        Task taskUpdated = taskService.updateTask(1L,taskDTO);

        assertNotNull(taskUpdated);
        assertEquals(1,taskUpdated.getId().intValue());
        assertEquals("Task DTO",taskUpdated.getName());
        assertEquals("Description DTO",taskUpdated.getDescription());
        assertEquals(FINALIZADA,taskUpdated.getStatus());
    }

    @Test
    void deleteTask() {
    }

    @Test
    void getTaskById() {
        when(taskRepository.findById(1L)).thenReturn(java.util.Optional.of(task1));
        Task task = taskRepository.findById(1L).orElse(null);
        assertNotNull(task);
        assertEquals(1,task.getId());
    }

    @Test
    void getTaskByIdNotFound(){
        when(taskRepository.findById(3L)).thenReturn(Optional.empty());

        assertNull(taskRepository.findById(3L).orElse(null));
    }

    @Test
    void getTasksByStatus() {
        when(taskRepository.findAllByStatus(En_ESPERA)).thenReturn(Arrays.asList(task2,task3));
        List<Task> tasks = taskRepository.findAllByStatus(En_ESPERA);
        assertNotNull(tasks);
        assertEquals(2,tasks.size());
        assertEquals(2,tasks.get(0).getId().intValue());
    }

    @Test
    void updateStatus() {

    }

    @Test
    void markAsCompleted() {
    }
}
