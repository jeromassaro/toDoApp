package tasks.toDoApp.model;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table (name = "task")
public class Task {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private boolean completed;
    private TaskStatus status;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        lastModifiedDate = LocalDateTime.now();
    }

    // Setea automáticamente al actualizar
    @PreUpdate
    protected void onUpdate() {
        lastModifiedDate = LocalDateTime.now();
    }
}
