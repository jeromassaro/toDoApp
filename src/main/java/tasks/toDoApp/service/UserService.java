package tasks.toDoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks.toDoApp.dto.UserCreationDTO;
import tasks.toDoApp.model.User;
import tasks.toDoApp.model.UserRole;
import tasks.toDoApp.respository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(UserCreationDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, UserCreationDTO userDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        user.setRole(UserRole.USER);
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUserPassword(Long id, String password) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        user.setPassword(password);
        return userRepository.save(user);
    }

    @Override
    public User updateUserRole(Long id, String role) {
        User user = userRepository.findById(id).orElse(null);
        if (user == null) return null;
        user.setRole(UserRole.valueOf(role));
        return userRepository.save(user);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
