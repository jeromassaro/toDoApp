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
    private String name;
    private String email;
    private String password;
    private UserRole role;
    @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL)
    private List<Task> taskList;
}
