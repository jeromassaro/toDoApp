package tasks.toDoApp.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Table (name = "user")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String username;
    private String password;
    private UserRole role;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Task> taskList;
}
