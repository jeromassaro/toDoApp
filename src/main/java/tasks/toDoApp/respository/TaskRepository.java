package tasks.toDoApp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tasks.toDoApp.model.Task;
import tasks.toDoApp.model.TaskStatus;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {

    public List<Task> findAllByStatus(TaskStatus status);

    @Modifying
    @Query("UPDATE Task t SET t.status = :status WHERE t.id = :id")
    public void updateStatus(@Param("id") Long id, @Param("status") TaskStatus status);
}
