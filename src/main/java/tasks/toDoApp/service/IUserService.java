package tasks.toDoApp.service;

import org.springframework.stereotype.Service;
import tasks.toDoApp.dto.UserCreationDTO;
import tasks.toDoApp.model.User;

import java.util.List;
import java.util.Optional;

@Service
public interface IUserService {

    public List<User> getUsers();
    public Optional<User> getUserById(Long id);
    public User getUserByEmail(String username);
    public User createUser(UserCreationDTO userDTO);
    public User updateUser(Long id, UserCreationDTO userDTO);
    public void deleteUser(Long id);
    public User updateUserPassword(Long id, String password);
    public User updateUserRole(Long id, String role);
}
